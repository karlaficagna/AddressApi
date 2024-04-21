package com.ficagna.addressApi.service.rest;

import com.ficagna.addressApi.model.entity.AddressDto;

public interface ExternalCepRestService {

    AddressDto searchByCep(Integer cep);

}
