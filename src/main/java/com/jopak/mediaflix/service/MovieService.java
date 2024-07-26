package com.jopak.mediaflix.service;

import com.jopak.mediaflix.DTO.MovieDTO;
import com.jopak.mediaflix.model.Movie;
import com.jopak.mediaflix.repository.MovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

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
        newMovie.setGenders(movieDTO.genders());
        newMovie.setTmdb(movieDTO.tmdbId());
        newMovie.setImdb(movieDTO.imdbId());
        newMovie.setTitle(movieDTO.title());
        newMovie.setUrl(movieDTO.url());
        System.out.println(newMovie.toString());
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
}
