package com.ficagna.addressApi.service.rest.implemantation;

import com.ficagna.addressApi.model.entity.Address;
import com.ficagna.addressApi.model.entity.AddressDto;
import com.ficagna.addressApi.service.rest.ExternalCepRestService;

public class ViaCepRestServiceImpl implements ExternalCepRestService {

    @Override
    public AddressDto searchByCep(Integer cep) {
        return Address.builder()
                .logradouro("Via cep")
                .cep(cep)
                .build();
    }


}
