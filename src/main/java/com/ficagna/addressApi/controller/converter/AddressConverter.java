package com.ficagna.addressApi.controller.converter;


import com.ficagna.addressApi.model.dto.AddressResponse;
import com.ficagna.addressApi.model.entity.Address;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AddressConverter {

    public static AddressResponse toResponse(Address address) {
        return AddressResponse.builder()
                .id(address.getId())
                .cep(address.getCep())
                .logradouro(address.getLogradouro())
                .numero(address.getNumero())
                .bairro(address.getBairro())
                .cidade(address.getCidade())
                .uf(address.getUf())
                .build();

    }
}




