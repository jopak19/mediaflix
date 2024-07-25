package com.jopak.mediaflix.repository;

import com.jopak.mediaflix.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpisodeRepository extends JpaRepository<Episode, Long> {
}
