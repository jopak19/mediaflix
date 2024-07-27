package com.jopak.mediaflix.service;

import com.jopak.mediaflix.DTO.MovieDTO;
import com.jopak.mediaflix.model.Gender;
import com.jopak.mediaflix.model.Movie;
import com.jopak.mediaflix.repository.GenderRepository;
import com.jopak.mediaflix.repository.MovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    GenderRepository genderRepository;

    @Autowired
    ModelMapper modelMapper;

    public Optional<Movie> findMovie(Long id){
        return movieRepository.findById(id);
    }
    public List<Movie> findAllMovie(){
        return movieRepository.findAll();
    }
    @Transactional
    public Movie createMovie(MovieDTO movieDTO){
        Movie newMovie = new Movie(); //modelMapper.map(movieDTO, Movie.class);
        List<Gender> genders = movieDTO.genders().stream()
                .map(name -> genderRepository.findByName(name).orElseThrow(() -> new RuntimeException("Genero not found: " + name)))
                .collect(Collectors.toList());
        newMovie.setGenders(genders);
        newMovie.setTmdb(movieDTO.tmdbId());
        newMovie.setImdb(movieDTO.imdbId());
        newMovie.setTitle(movieDTO.title());
        newMovie.setUrl(movieDTO.url());
        //modelMapper.map(newMovie, Movie.class);
        movieRepository.save(newMovie);
        return newMovie;
    }

    public Movie updateMovie(Long id, MovieDTO movieDTO){
        Optional<Movie> oldMovie = movieRepository.findById(id);
        if (oldMovie.isEmpty()){
            return null;
        }
        Movie updatedMovie = oldMovie.get();
        updatedMovie = modelMapper.map(movieDTO, Movie.class);
        movieRepository.save(updatedMovie);
        return updatedMovie;
    }
    public boolean deleteMovie(Long id){
        Optional<Movie> oldMovie = movieRepository.findById(id);
        if (oldMovie.isEmpty()){
            return false;
        }else {
            movieRepository.deleteById(id);
            return true;
        }
    }
}
