package com.ficagna.projetoPokedex.model.entity;

import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PokemonDto {

    private Long id;
    private String name;
    private Integer hight;
    private Integer weight;

    public PokemonDto(Pokemon pokemon) {
    }

    public static List<PokemonDto> converterParaEntity(List<Pokemon> pokemons) {
        return pokemons
                .stream()
                .map(PokemonDto::new)
                .collect(Collectors.toList());
    }


}

