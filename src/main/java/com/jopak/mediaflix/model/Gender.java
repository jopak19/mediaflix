package com.jopak.mediaflix.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Gender {
    @Id
    String name;
    /*
    TERROR,
    ACAO,
    DRAMA,
    COMEDIA,
    ANIME,
    FICCAOCIENTIFICA,
    AVENTURA,
    SUSPENSE
    */

}
