package com.jopak.mediaflix.controller;

import com.jopak.mediaflix.model.Movie;
import com.jopak.mediaflix.model.Teste;
import com.jopak.mediaflix.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PutMapping
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movieBody){
       return  null;
       // TODO: update a movie based at moviebody
    }

}
