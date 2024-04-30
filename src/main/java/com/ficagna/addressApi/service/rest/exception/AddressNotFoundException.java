package com.ficagna.addressApi.service.rest.exception;

import org.springframework.http.HttpStatus;

public class AddressNotFoundException extends BusinessException {

    private static final  String DEFAULT_MESSAGE = "Cep %s não foi encontrado";

   public AddressNotFoundException(Integer cep) {
        super(HttpStatus.NOT_FOUND, String.valueOf(Integer.valueOf(DEFAULT_MESSAGE, cep)));
    }
}
