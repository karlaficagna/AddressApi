package com.ficagna.addressApi.service;

import com.ficagna.addressApi.controller.resourses.AddressRequest;
import com.ficagna.addressApi.controller.resourses.AddressResponse;
import com.ficagna.addressApi.model.entity.Address;
import com.ficagna.addressApi.model.entity.AddressDto;
import com.ficagna.addressApi.model.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressIntegrationService {

<<<<<<< HEAD
    private final RestTemplate restTemplate;
    @Value("${app.cep.fallback-order}")
    private final String uri;
    public List<AddressDto> addressDtos = new ArrayList<>();


    @Autowired
    private AddressRepository addressRepository;

    public AddressIntegrationService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
        this.uri = "app.cep.fallback-order=VIACEP,CEPABERTO,BRASILAPI";
    }

    public com.ficagna.addressApi.model.entity.AddressDto findById(Long id) {
        String url = generateURLIntegration(id);
        return this.restTemplate.getForObject(url, AddressDto.class);
    }

    private String generateURLIntegration(Long id) {
        return this.uri + "/" + id;
    }

    public AddressDto findByCep(String cep) {
        String url = generateURLIntegration(cep);
        return this.restTemplate.getForObject(url, AddressDto.class);
    }

    private String generateURLIntegration(String cep) {
        return this.uri + "/" + cep;
    }
=======
    private final ExternalCepRestService externalCepRestService;;


    public AddressDto findAddressByCep(String cep) {

        return externalCepRestService.searchByCep(cep);
    }

>>>>>>> 5912b04 (AddressApi)

    public AddressResponse salvar(AddressRequest addressRequest) {
        Address addressConvertido = addressRequest.converterParaEntity();
        Address addressSalvo = addressRepository.salvar(addressConvertido);
<<<<<<< HEAD
        AddressResponse produtoResponse = new AddressResponse(addressSalvo.getId());
        return AddressResponse.builder().build();
    }

    public List<Address> procuraTodos() {

        return addressRepository.findAll();
    }


=======
        AddressResponse addressResponse = new AddressResponse(addressSalvo.getId());
        return AddressResponse.builder().build();
    }

>>>>>>> 5912b04 (AddressApi)
}


