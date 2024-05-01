package com.ficagna.addressApi.service.rest;

import com.ficagna.addressApi.service.rest.implemantation.BrasilApiRestServiceImpl;
import com.ficagna.addressApi.service.rest.implemantation.CepAbertoServiceImpl;
import com.ficagna.addressApi.service.rest.implemantation.ViaCepRestServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ExternalCepFactory {

    private static final Map<String, ExternalCepRestService> EXTERNAL_SYSTEMS = Map.of(
            "VIACEP",
            new ViaCepRestServiceImpl(),
            "CEPABERTO",
            new CepAbertoServiceImpl(),
            "BRASILAPI",
            new BrasilApiRestServiceImpl()
    );

    private final Map<String, ExternalCepRestService> externalCepRestServiceMap;

    public ExternalCepRestService create(String api) {


        return Optional.ofNullable(externalCepRestServiceMap.get(api))
                .orElseThrow(() -> new RuntimeException("Não foi possivel encontrar uma implementação de cep"));

    }
}

