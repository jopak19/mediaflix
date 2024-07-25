package com.jopak.mediaflix.repository;

import com.jopak.mediaflix.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
