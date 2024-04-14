package com.ficagna.projetoPokedex.controller;

import com.ficagna.projetoPokedex.config.validação.HeigthNotFindException;
import com.ficagna.projetoPokedex.config.validação.PokemonNotFindException;
import com.ficagna.projetoPokedex.controller.resourses.AddHeightRequest;
import com.ficagna.projetoPokedex.controller.resourses.PokemonRequest;
import com.ficagna.projetoPokedex.controller.resourses.PokemonResponse;
import com.ficagna.projetoPokedex.model.entity.Pokemon;
import com.ficagna.projetoPokedex.model.entity.PokemonDto;
import com.ficagna.projetoPokedex.model.repository.PokemonRepository;
import com.ficagna.projetoPokedex.service.PokemonIntegrationService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("api/v1/pokemons")
@CrossOrigin(origins = "*")
public class PokemonController {

    @Autowired
    private PokemonIntegrationService pokemonIntegrationService;
    private PokemonRepository pokemonRepository;

    public PokemonController(PokemonIntegrationService pokemonIntegrationService) {
        this.pokemonIntegrationService = pokemonIntegrationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PokemonDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(pokemonIntegrationService.findById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<PokemonDto> findByName(@PathVariable String name) {
        return ResponseEntity.ok(pokemonIntegrationService.findByName(name));
    }

    @PostMapping
    public ResponseEntity<PokemonResponse> salvar(@RequestBody @Valid PokemonRequest pokemonRequest) {
        PokemonResponse pokemonSalvo = pokemonIntegrationService.salvar(pokemonRequest);
        return new ResponseEntity<>(pokemonSalvo, HttpStatus.CREATED);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> delete(@RequestParam String name) {
        pokemonIntegrationService.deletePokemon(name);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @PutMapping("{id}/height")
    public ResponseEntity<Void> addHeight(
            @PathVariable Long id,
            @RequestBody AddHeightRequest request
    ) {
        try {
            pokemonIntegrationService.addHeight(Long.valueOf(id), request);
        } catch (PokemonNotFindException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (HeigthNotFindException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<Pokemon>> procuraTodosPokemons() {
        return ResponseEntity.ok(this.pokemonIntegrationService.procuraTodosPokemons());
    }

}

