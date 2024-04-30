package com.ficagna.addressApi.service.rest.implemantation;


import com.ficagna.addressApi.model.entity.Address;
import com.ficagna.addressApi.service.rest.ExternalCepRestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@RequiredArgsConstructor
@Slf4j
public class CepAbertoServiceImpl implements ExternalCepRestService {

    @Override
    public Address findByCep(Integer cep) {
        log.error("Cep não localizado");
        throw new RuntimeException("Cep não localizado");
//        return Address.builder()
//                .logradouro("Cep Aberto")
//                .cep(cep)
//                .build();
    }
}
