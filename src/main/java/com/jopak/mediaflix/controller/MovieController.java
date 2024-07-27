package com.jopak.mediaflix.controller;

import com.jopak.mediaflix.DTO.MovieDTO;
import com.jopak.mediaflix.model.Movie;
import com.jopak.mediaflix.repository.MovieRepository;
import com.jopak.mediaflix.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    MovieRepository movieRespository;
    @Autowired
    MovieService movieService;
    @GetMapping
    public List<Movie> getAllMovies(){
        return movieService.findAllMovie();
    }
    @GetMapping(value = "/{id}")
    public Optional<Movie> getMovie(@PathVariable  Long id){
        return movieService.findMovie(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody MovieDTO movieBody){
        Movie movie = movieService.updateMovie(id, movieBody);
        if (movie != null){
           return new ResponseEntity<Movie>(HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody MovieDTO movieDTO){
        Movie movie = movieService.createMovie(movieDTO);
        if (movie != null){
            return new ResponseEntity<Movie>(HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable Long id){
        if (movieService.deleteMovie(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
