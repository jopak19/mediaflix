package com.jopak.mediaflix.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public abstract class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    @Setter String title;
    @Column(nullable = false)
    @Setter String url;
    @Column(nullable = false)
    @Setter String imdb;
    @Column(nullable = false)
    @Setter String tmdb;

}
