package com.jopak.mediaflix.DTO;

import com.jopak.mediaflix.model.Gender;

import java.util.List;

public record MovieDTO(
        List<String> genders,
        String title,
        String url,
        String imdbId,
        String tmdbId) {

}
