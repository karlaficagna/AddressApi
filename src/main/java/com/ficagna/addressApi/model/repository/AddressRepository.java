package com.ficagna.addressApi.model.repository;

import com.ficagna.addressApi.model.entity.Address;
import com.ficagna.addressApi.model.entity.AddressDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    @Transactional
    @Modifying

    @Query("SELECT pk FROM Address pk WHERE pk.id = :id")
    Optional searchById(@Param("id") Long id);

    @Query("SELECT pk FROM Cep pk WHERE pk.cep LIKE %:cep%")
    Address searchByCep(@Param("cep") String cep);


    Address salvar(AddressDto addressConvertido);
}
