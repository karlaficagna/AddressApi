package com.ficagna.addressApi.service.rest;

import com.ficagna.addressApi.model.entity.Address;

public interface ExternalCepRestService {
    Address findByCep(Integer cep);

}
