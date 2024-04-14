package com.ficagna.projetoPokedex.service;


import com.ficagna.projetoPokedex.model.entity.PokemonDto;

public class PokemonConverter {

    public static PokemonDto converter(PokemonDto pokemon) {
        String pokemonName = pokemon.getName();
        pokemon.setName(tornarPrimeiraLetraMaiuscula(pokemonName));
        return pokemon;

    }
    private static String tornarPrimeiraLetraMaiuscula(String pokemonName) {
        return pokemonName.substring(0,1).toUpperCase() + pokemonName.substring(1);
    }
}




