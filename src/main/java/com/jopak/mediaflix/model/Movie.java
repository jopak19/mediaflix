package com.jopak.mediaflix.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Movie extends Media implements Serializable {
    @ElementCollection(targetClass = Gender.class)
    @CollectionTable
    @Enumerated(EnumType.STRING)
    @Getter
    List<Gender> genders;

}
