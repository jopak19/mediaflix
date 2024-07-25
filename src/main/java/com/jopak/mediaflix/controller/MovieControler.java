package com.jopak.mediaflix.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jopak.mediaflix.model.Movie;
import com.jopak.mediaflix.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("/movie")
public class MovieControler {
    @Autowired
    MovieRepository movieRespository;
    @GetMapping(value = "/")
    public List<Movie> getAllMovies(){
        return movieRespository.findAll();
    }
    @GetMapping(value = "/id")
    public Optional<Movie> getMovie(@PathVariable  Long id){
        return movieRespository.findById(id);
    }

    /**/
    @PutMapping("/id")
    public ResponseEntity<Movie> updateMovie(PathVariable id, @RequestBody Movie movieBody){
        var objectMapper = new ObjectMapper();
       Optional<Movie> oldMovie = movieRespository.findById(movieBody.getId());
       if (oldMovie.isEmpty()){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
       //oldMovie = objectMapper.readValue(movieBody, Movie.class);

       // TODO: update a movie based at moviebody
    }


}
