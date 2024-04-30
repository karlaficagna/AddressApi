package com.ficagna.addressApi.service.rest.implemantation;

import com.ficagna.addressApi.model.entity.Address;
import com.ficagna.addressApi.service.rest.ExternalCepRestService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ViaCepRestServiceImpl implements ExternalCepRestService {

    @Override
    public Address findByCep(Integer cep) {
        return Address.builder()
                .logradouro("Via cep")
                .cep(cep)
                .build();
    }


}
