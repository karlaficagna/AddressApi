package com.ficagna.addressApi.service.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ExternalCepFactory {

    private final Map<String, ExternalCepRestService> externalCepRestServiceMap;

    public ExternalCepRestService create(String api) {


        return Optional.ofNullable(externalCepRestServiceMap.get(api))
                .orElseThrow(() -> new RuntimeException("Não foi possivel encontrar uma implementação de cep"));

    }
}

