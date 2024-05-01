package com.ficagna.addressApi.service.rest;

import com.ficagna.addressApi.model.entity.Address;

import java.io.IOException;

public interface ExternalCepRestService {

    Address findByCep(Integer cep) throws IOException;

}
