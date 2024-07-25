package domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.atn.EpsilonTransition;

import java.util.List;
@Getter
@Setter
@Entity
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serie")
    List<Episode> episodes;

    @ElementCollection(targetClass = Gender.class)
    @CollectionTable
    @Enumerated(EnumType.STRING)
    List<Gender> genders;
}
