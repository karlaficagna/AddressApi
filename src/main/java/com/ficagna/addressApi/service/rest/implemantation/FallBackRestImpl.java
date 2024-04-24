package com.ficagna.addressApi.service.rest.implemantation;


import com.ficagna.addressApi.model.entity.AddressDto;
import com.ficagna.addressApi.service.rest.ExternalCepRestService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FallBackRestImpl implements ExternalCepRestService {
    private final List<Integer> fallbackOrder;
    private List<ExternalCepRestService> externalImpl =
            List.of();

    public AddressDto searchByCep(String cep) {

        AddressDto response = null;
        for (ExternalCepRestService externalService : externalImpl) {
            try {
                 response = externalService.searchByCep(Integer.valueOf(cep));
                 break;
            } catch (RuntimeException ex) {
                continue;
            }
        }
        return response;
    }

    @Override
    public AddressDto searchByCep(Integer cep) {
        return null;
    }
}
