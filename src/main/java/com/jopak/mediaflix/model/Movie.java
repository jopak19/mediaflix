package com.jopak.mediaflix.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Movie extends Media implements Serializable {

    @ElementCollection(targetClass = Gender.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "filme_generos" )
    //@Column(name = "gender", nullable = false)
    List<Gender> genders;

    @Override
    public String toString() {
        return "Movie{" +
                "genders=" + genders +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", imdb='" + imdb + '\'' +
                ", tmdb='" + tmdb + '\'' +
                '}';
    }
}
