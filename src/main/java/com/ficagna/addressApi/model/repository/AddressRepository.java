package com.ficagna.addressApi.model.repository;

import com.ficagna.addressApi.model.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
<<<<<<< HEAD
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<com.ficagna.addressApi.model.entity.Address, Long> {
    @Transactional
    @Modifying
    @Query("SELECT pk FROM Address pk WHERE pk.id = :id")
    Optional findById(@Param("id") Long id);

    @Query("SELECT pk FROM Cep pk WHERE pk.cep LIKE %:cep%")
    Address findByName(@Param("cep") String cep);

    @Query("SELECT count(pk) FROM Address pk WHERE pk.cep LIKE %:cep%")
    Integer cepAlreadyExistsInternallyByCep(@Param("cep") String cep);
=======

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    @Transactional
    @Modifying

    @Query("SELECT pk FROM Cep pk WHERE pk.cep LIKE %:cep%")
    Address findAddressByCep(@Param("cep") Integer cep);
>>>>>>> 5912b04 (AddressApi)

    Address salvar(Address addressConvertido);
}
