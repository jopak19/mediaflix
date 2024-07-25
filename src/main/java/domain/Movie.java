package domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Movie extends Media{
    @ElementCollection(targetClass = Gender.class)
    @CollectionTable
    @Enumerated(EnumType.STRING)
    List<Gender> genders;

}
