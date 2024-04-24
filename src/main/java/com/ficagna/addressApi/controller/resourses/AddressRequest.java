package com.ficagna.addressApi.controller.resourses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ficagna.addressApi.model.entity.Address;
import com.ficagna.addressApi.model.entity.AddressDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Getter
@Setter
@AllArgsConstructor
public class AddressRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @JsonProperty("address")
    private Integer cep;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String uf;

    public AddressRequest() {
    }

    public AddressDto converterParaEntity() {
        return new AddressDto();
    }
}



