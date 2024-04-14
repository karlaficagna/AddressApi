package com.ficagna.projetoPokedex.service;

import com.ficagna.projetoPokedex.controller.resourses.AddHeightRequest;
import com.ficagna.projetoPokedex.controller.resourses.PokemonRequest;
import com.ficagna.projetoPokedex.controller.resourses.PokemonResponse;
import com.ficagna.projetoPokedex.model.entity.Pokemon;
import com.ficagna.projetoPokedex.model.entity.PokemonDto;
import com.ficagna.projetoPokedex.model.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonIntegrationService {

    private final RestTemplate restTemplate;
    @Value("${pokemon-external-api}")
    private final String uri;
    public List<PokemonDto> pokemons = new ArrayList<>();

    @Autowired
    private PokemonRepository pokemonRepository;

    public PokemonIntegrationService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
        this.uri = "https://pokeapi.co/api/v2/pokemon";
    }

    public PokemonDto findById(Long id) {
        String url = generateURLIntegration(id);
        return this.restTemplate.getForObject(url, PokemonDto.class);
    }

    private String generateURLIntegration(Long id) {
        return this.uri + "/" + id;
    }

    public PokemonDto findByName(String name) {
        String url = generateURLIntegration(name);
        return this.restTemplate.getForObject(url, PokemonDto.class);
    }

    private String generateURLIntegration(String name) {
        return this.uri + "/" + name;
    }


    public void deletePokemon(String name) {
        for (PokemonDto pokemon : pokemons) {
            if (pokemon.getName().equals(name)) {
                pokemons.remove(pokemon);
                break;
            }
        }
    }
    public PokemonResponse salvar(PokemonRequest pokemonRequest) {
        Pokemon pokemonConvertido = pokemonRequest.converterParaEntity();
        Pokemon pokemonSalvo = pokemonRepository.salvar(pokemonConvertido);
        PokemonResponse produtoResponse = new PokemonResponse(pokemonSalvo.getId());
        return PokemonResponse.builder().build();
    }

    public List<Pokemon> procuraTodosPokemons() {
        return pokemonRepository.findAll();
    }

    public void addHeight(Long id, AddHeightRequest request) {
    }



}


