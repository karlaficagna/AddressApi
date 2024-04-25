package com.ficagna.addressApi.service;

import com.ficagna.addressApi.controller.resourses.AddressRequest;
import com.ficagna.addressApi.controller.resourses.AddressResponse;
import com.ficagna.addressApi.model.entity.Address;
import com.ficagna.addressApi.model.entity.AddressDto;
import com.ficagna.addressApi.model.repository.AddressRepository;
import com.ficagna.addressApi.service.rest.ExternalCepRestService;
import com.ficagna.addressApi.service.rest.implemantation.exception.AddressNotFoundException;
import com.ficagna.addressApi.service.rest.implemantation.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class AddressIntegrationService {

    private final RestTemplate restTemplate;
    private final String uri;

    private AddressRepository addressRepository;

    public AddressIntegrationService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
        this.uri = "app.cep.fallback-order=VIACEP,CEPABERTO,BRASILAPI";
    }

    public AddressResponse findById(Long id) {
        String url = generateURLIntegration(id);
        try {
            return this.restTemplate.getForObject(url, AddressResponse.class);
        } catch (HttpClientErrorException ex) {
            if (HttpStatus.NOT_FOUND.equals(ex.getStatusCode())) {
                throw new AddressNotFoundException(Long.valueOf(id.longValue());
            }
            throw new BusinessException(ex.getStatusCode());
        }
    }

     public AddressResponse findByCep(Integer cep) {
        String url = generateURLIntegration(cep);
        try {
            return this.restTemplate.getForObject(url, AddressResponse.class);
        } catch (HttpClientErrorException ex) {
            if (HttpStatus.NOT_FOUND.equals(ex.getStatusCode())) {
                throw new AddressNotFoundException(Long.valueOf(cep.toString()));
            }
            throw new BusinessException(ex.getStatusCode());
        }
    }

    private String generateURLIntegration(Long id) {
        return this.uri + "/" + id;
    }

    private String generateURLIntegration(Integer cep) {
        return this.uri + "/" + cep;
    }


    public AddressResponse salvar(AddressRequest addressRequest) {
        AddressDto addressConvertido = addressRequest.converterParaEntity();
        Address addressSalvo = addressRepository.salvar(addressConvertido);
        AddressResponse addressResponse = new AddressResponse(addressSalvo.getId());
        return AddressResponse.builder().build();

    }

    public AddressDto searchByCep(Integer cep) {
        return new Address();
    }
}



