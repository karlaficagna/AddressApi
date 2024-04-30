package com.ficagna.addressApi.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Address")
public class AddressResponse {

    @ApiModelProperty
    private Long id;
    @ApiModelProperty("cep_address")
    private Integer cep;
    @ApiModelProperty("logradouro_address")
    private String logradouro;
    @ApiModelProperty("numero_address")
    private Integer numero;
    @ApiModelProperty("bairro_address")
    private String bairro;
    @ApiModelProperty("cidade_address")
    private String cidade;
    @ApiModelProperty("uf_address")
    private String uf;

}
