package com.ficagna.addressApi.service.rest.implemantation;

import com.ficagna.addressApi.model.dto.BrasilApiResponseDTO;
import com.ficagna.addressApi.model.entity.Address;
import com.ficagna.addressApi.service.rest.ExternalCepRestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
public class BrasilApiRestServiceImpl implements ExternalCepRestService {

    @Override
    public Address findByCep(Integer cep) {
        RestTemplate restTemplate = new RestTemplate();
        String brasilApiUrl = "https://brasilapi.com.br/api/cep/v1/" + cep;
        BrasilApiResponseDTO brasilApiResponseDTO = restTemplate.getForObject(brasilApiUrl, BrasilApiResponseDTO.class);
        if (brasilApiResponseDTO != null) {
            return Address.builder()
                    .numero(0)
                    .bairro(brasilApiResponseDTO.getNeighborhood())
                    .uf(brasilApiResponseDTO.getState())
                    .logradouro(brasilApiResponseDTO.getStreet())
                    .cep(cep)
                    .cidade(brasilApiResponseDTO.getCity())
                    .build();
        }
        return Address.builder()
                .logradouro("Brasil api")
                .cep(cep)
                .build();
    }
}


