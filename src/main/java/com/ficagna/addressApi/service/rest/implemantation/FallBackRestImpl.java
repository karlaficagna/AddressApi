package com.ficagna.addressApi.service.rest.implemantation;


import com.ficagna.addressApi.model.entity.Address;
import com.ficagna.addressApi.service.rest.ExternalCepRestService;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RequiredArgsConstructor
public class FallBackRestImpl implements ExternalCepRestService {
    private final List<String> fallbackOrder;
    private final Map<String, ExternalCepRestService> externalImpl;


    public Address searchByCep(Integer cep) {

        Address response = null;
        for (ExternalCepRestService externalService : externalImpl.values()) {
            try {
                 response = externalService.findByCep(Integer.valueOf(cep));
                 break;
            } catch (RuntimeException ex) {
                continue;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return response;
    }

    @Override
    public Address findByCep(Integer cep) {

        return null;
    }
}
