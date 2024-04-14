package com.ficagna.projetoPokedex.controller.create;

import com.ficagna.projetoPokedex.controller.resourses.PokemonResponse;
import com.ficagna.projetoPokedex.model.entity.Pokemon;
import com.ficagna.projetoPokedex.model.repository.PokemonRepository;
import lombok.AllArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NotNull
@NotEmpty
@AllArgsConstructor
public class PokemonCreate {

    private Long id;
    private String name;
    private int height;
    private int weight;

    public Pokemon converter(PokemonResponse pokemonResponse) {
        Pokemon pokecreate = pokemonResponse.findByName(name);
        return new Pokemon(id, name, height, weight);
    }
}
