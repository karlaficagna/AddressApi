package com.ficagna.addressApi.service.rest.implemantation;

import com.ficagna.addressApi.model.entity.Address;
import com.ficagna.addressApi.service.rest.ExternalCepRestService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BrasilApiRestServiceImpl implements ExternalCepRestService {

    @Override
    public Address findByCep(Integer cep) {
        return Address.builder()
                .logradouro("Brasil api")
                .cep(cep)
                .build();
    }

}
