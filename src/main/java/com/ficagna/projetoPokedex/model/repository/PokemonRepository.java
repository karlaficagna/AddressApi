package com.ficagna.projetoPokedex.model.repository;

import com.ficagna.projetoPokedex.model.entity.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    @Transactional
    @Modifying
    @Query("delete from Pokemon pk where pk.name = ?1")
    int deleteByName(String name);

    @Query("SELECT pk FROM Pokemon pk WHERE pk.id = :id")
    Optional<Pokemon> findById(@Param("id") Long id);

    @Query("SELECT pk FROM Pokemon pk WHERE pk.name LIKE %:name%")
    Pokemon findByName(@Param("name") String name);

    @Query("SELECT count(pk) FROM Pokemon pk WHERE pk.name LIKE %:name%")
    Integer pokeAlreadyExistsInternallyByName(@Param("name") String name);

    Pokemon salvar(Pokemon pokemonConvertido);
}
