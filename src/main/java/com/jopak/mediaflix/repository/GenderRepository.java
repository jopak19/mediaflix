package com.jopak.mediaflix.repository;

import com.jopak.mediaflix.model.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GenderRepository extends JpaRepository<Gender, String> {
    Optional<Gender> findByName(String name);

    long deleteByName(String name);
}
