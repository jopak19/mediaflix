package com.jopak.mediaflix.repository;

import com.jopak.mediaflix.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepository extends JpaRepository<Serie, Long> {
}
