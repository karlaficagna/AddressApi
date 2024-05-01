package com.ficagna.addressApi.controller;

import com.ficagna.addressApi.model.entity.Address;
import com.ficagna.addressApi.service.CepService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(path = "/cep")
@RequiredArgsConstructor
public class AddressController {

    private final CepService cepService;

    @GetMapping
    public Address getAddressByCep(@RequestParam("cep") Integer cep) throws IOException {

        return cepService.searchAddress(cep);
    }
}

