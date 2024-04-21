package com.ficagna.addressApi.service;

import com.ficagna.addressApi.controller.resourses.AddressRequest;
import com.ficagna.addressApi.controller.resourses.AddressResponse;
import com.ficagna.addressApi.model.entity.Address;
import com.ficagna.addressApi.model.entity.AddressDto;
import com.ficagna.addressApi.model.repository.AddressRepository;
import com.ficagna.addressApi.service.rest.ExternalCepRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressIntegrationService {

    private final RestTemplate restTemplate;
    @Value("${app.cep.fallback-order}")
    private final String uri;
    public List<AddressDto> addressDtos = new ArrayList<>();

    @Autowired
    private AddressRepository addressRepository;

    public AddressIntegrationService(RestTemplateBuilder restTemplateBuilder, ExternalCepRestService externalCepRestService) {
        this.restTemplate = restTemplateBuilder.build();
        this.externalCepRestService = externalCepRestService;
        this.uri = "app.cep.fallback-order=VIACEP,CEPABERTO,BRASILAPI";
    }

    public com.ficagna.addressApi.model.entity.AddressDto findById(Long id) {
        String url = generateURLIntegration(id);
        return this.restTemplate.getForObject(url, AddressDto.class);
    }

    private String generateURLIntegration(Long id) {
        return this.uri + "/" + id;
    }

    public AddressDto findByCep(Integer cep) {
        String url = generateURLIntegration(cep);
        return this.restTemplate.getForObject(url, AddressDto.class);
    }

    private String generateURLIntegration(Integer cep) {
        return this.uri + "/" + cep;
    }

    private final ExternalCepRestService externalCepRestService;


    public AddressDto searchByCep(Integer cep) {
        return externalCepRestService.searchByCep(cep);
    }


    public AddressResponse salvar(AddressRequest addressRequest) {
        Address addressConvertido = addressRequest.converterParaEntity();
        Address addressSalvo = addressRepository.salvar(addressConvertido);

        AddressResponse addressResponse = new AddressResponse(addressSalvo.getId());
        return AddressResponse.builder().build();
    }


}



