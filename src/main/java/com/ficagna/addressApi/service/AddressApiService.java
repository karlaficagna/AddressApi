package com.ficagna.addressApi.service;

import com.ficagna.addressApi.model.dto.BrasilApiResponseDTO;
import com.ficagna.addressApi.service.rest.exception.AddressNotFoundException;
import com.ficagna.addressApi.service.rest.exception.BusinessException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class AddressApiService {

    private final RestTemplate restTemplate;
    private final String uri;

        public AddressApiService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
        this.uri = "app.cep.fallback-order=VIACEP,CEPABERTO,BRASILAPI";
    }

    public BrasilApiResponseDTO findById(Long id) {
        String url = generateURLIntegration(id);
        try {
            return this.restTemplate.getForObject(url, BrasilApiResponseDTO.class);
        } catch (HttpClientErrorException ex) {
            if (HttpStatus.NOT_FOUND.equals(ex.getStatusCode())) {
                throw new AddressNotFoundException((id.intValue()));
            }
            throw new BusinessException(ex.getStatusCode());
        }
    }

    public BrasilApiResponseDTO findByCep(Integer cep) {
        String url = generateURLIntegration(cep);
        try {
            return this.restTemplate.getForObject(url, BrasilApiResponseDTO.class);
        } catch (HttpClientErrorException ex) {
            if (HttpStatus.NOT_FOUND.equals(ex.getStatusCode())) {
                throw new AddressNotFoundException((cep));
            }
            throw new BusinessException(ex.getStatusCode());
        }
    }

    private String generateURLIntegration(Long id) {

        return this.uri + "/addressapi" + id;
    }

    private String generateURLIntegration(Integer cep) {

        return this.uri + "/addressapi" + cep;
    }


}






