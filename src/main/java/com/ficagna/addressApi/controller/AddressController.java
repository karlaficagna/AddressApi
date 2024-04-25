package com.ficagna.addressApi.controller;

import com.ficagna.addressApi.controller.resourses.AddressRequest;
import com.ficagna.addressApi.controller.resourses.AddressResponse;
import com.ficagna.addressApi.model.entity.AddressDto;
import com.ficagna.addressApi.model.repository.AddressRepository;
import com.ficagna.addressApi.service.AddressIntegrationService;
import com.ficagna.addressApi.service.CepService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@NoArgsConstructor
@AllArgsConstructor
@RestController
@RequestMapping(path = "/cep")
public class AddressController {


    @Autowired
    private AddressIntegrationService addressIntegrationService;
    private AddressRepository addressRepository;
    private CepService cepService;

    public AddressController(CepService cepService) {
        this.cepService = cepService;
    }

    @GetMapping
    public AddressDto getAddressByCep(@RequestParam("cep") Integer cep) {
        return cepService.searchAddress(cep);
    }

    public AddressController(CepService cepService, AddressIntegrationService addressIntegrationService) {
        this.cepService = cepService;
        this.addressIntegrationService = addressIntegrationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(addressIntegrationService.findById(id));
    }

    @GetMapping("/cep/{cep}")
    public ResponseEntity<AddressDto> searchByCep(@PathVariable Integer cep) {
        return ResponseEntity.ok(addressIntegrationService.searchByCep(cep));
    }

    @PostMapping
    public ResponseEntity<AddressResponse> salvar(@RequestBody @Valid AddressRequest addressRequest) {
        AddressResponse addressSalvo = addressIntegrationService.salvar(addressRequest);
        return new ResponseEntity<>(addressSalvo, HttpStatus.CREATED);

    }

}

