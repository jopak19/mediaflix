package com.jopak.mediaflix.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToMany(cascade = CascadeType.ALL)
    List<Episode> episodes;

    @ElementCollection(targetClass = Gender.class)
    @CollectionTable
    @Enumerated(EnumType.STRING)
    List<Gender> genders;
}
