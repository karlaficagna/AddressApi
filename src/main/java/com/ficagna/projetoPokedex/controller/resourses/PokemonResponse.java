package com.ficagna.projetoPokedex.controller.resourses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ficagna.projetoPokedex.model.entity.Pokemon;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import nonapi.io.github.classgraph.json.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Pokemon")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PokemonResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty
    private Long id;
    @ApiModelProperty("nome_pokemon")
    private String name;
    @ApiModelProperty("altura_pokemon")
    private Integer height;
    @ApiModelProperty("peso_pokemon")
    private Integer weight;
    @ApiModelProperty
    private String url;

    public PokemonResponse (Pokemon pokemonSalvo){
        this.id = pokemonSalvo.getId();
        this.name = pokemonSalvo.getName();
        this.height = pokemonSalvo.getHeight();
        this.weight = pokemonSalvo.getWeight();

    }

    public PokemonResponse(Long id) {
    }

    public Pokemon findByName(String name) {
    }
}
