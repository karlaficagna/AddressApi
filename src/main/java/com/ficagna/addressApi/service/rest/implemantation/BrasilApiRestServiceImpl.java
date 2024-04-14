package com.ficagna.addressApi.service.rest.implemantation;

import com.ficagna.addressApi.model.entity.AddressDto;

public class BrasilApiRestServiceImpl {

    @Override
    public AddressDto findAddressByCep(Integer cep) {
        return AddressDto.builder()
                .logradouro("Brasil api")
                .cep(cep)
                .build();
    }

}
