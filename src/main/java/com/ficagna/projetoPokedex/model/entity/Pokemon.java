package com.ficagna.projetoPokedex.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "pokedex")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 80, nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer height;

    @Column(nullable = false)
    private Integer weight;


//    @ManyToMany
    //    private List<Type> types;
    //    private List<Move> moves;

    public Pokemon(Long id, String name, Integer height, Integer weight) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    public Pokemon(String name, Integer height, Integer weight) {
    }
}

