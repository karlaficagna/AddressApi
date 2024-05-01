package com.ficagna.addressApi.repository;

import com.ficagna.addressApi.model.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Address findByCep(Integer cep);
}
