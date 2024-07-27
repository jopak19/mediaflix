package com.jopak.mediaflix.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.internal.bytebuddy.dynamic.loading.InjectionClassLoader;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique = true)
    String name;

    public Gender(String genderName) {
        this.name = genderName;
    }
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
