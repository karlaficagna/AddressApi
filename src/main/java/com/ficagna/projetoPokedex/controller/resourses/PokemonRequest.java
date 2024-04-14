package com.ficagna.projetoPokedex.controller.resourses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ficagna.projetoPokedex.model.entity.Pokemon;
import com.ficagna.projetoPokedex.model.entity.PokemonDto;
import lombok.Getter;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Getter
@Setter
public class PokemonRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;
    @JsonProperty("nome_pokemon")
    private String name;
    @JsonProperty("altura_pokemon")
    private Integer height;
    @JsonProperty("peso_pokemon")
    private Integer weight;

    public PokemonRequest() {
    }

    public Pokemon converterParaEntity() {
        return new Pokemon();
    }
}



