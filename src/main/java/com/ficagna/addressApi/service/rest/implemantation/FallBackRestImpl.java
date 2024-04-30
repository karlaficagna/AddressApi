package com.ficagna.addressApi.service.rest.implemantation;


import com.ficagna.addressApi.model.entity.Address;
import com.ficagna.addressApi.service.rest.ExternalCepRestService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FallBackRestImpl implements ExternalCepRestService {
    private final List<String> fallbackOrder;
    private List<ExternalCepRestService> externalImpl =
            List.of();


    public Address searchByCep(String cep) {

        Address response = null;
        for (ExternalCepRestService externalService : externalImpl) {
            try {
                 response = externalService.findByCep(Integer.valueOf(cep));
                 break;
            } catch (RuntimeException ex) {
                continue;
            }
        }
        return response;
    }

    @Override
    public Address findByCep(Integer cep) {
        return null;
    }
}
