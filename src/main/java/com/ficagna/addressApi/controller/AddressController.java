package com.ficagna.addressApi.controller;

import com.ficagna.addressApi.model.entity.Address;
import com.ficagna.addressApi.service.AddressApiService;
import com.ficagna.addressApi.service.CepService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/cep")
@RequiredArgsConstructor
public class AddressController {

    private final CepService cepService;

            public Address getAddressByCep (@RequestParam("cep") Integer cep) {
                return cepService.searchAddress(cep);
    }
}

