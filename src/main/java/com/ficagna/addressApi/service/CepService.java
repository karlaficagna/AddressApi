package com.ficagna.addressApi.service;

import com.ficagna.addressApi.model.entity.Address;
import com.ficagna.addressApi.service.rest.ExternalCepRestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CepService {

    private final ExternalCepRestService externalCepRestService;


    public Address searchAddress(Integer cep) {
        return externalCepRestService.searchByCep(cep);
    }

}
