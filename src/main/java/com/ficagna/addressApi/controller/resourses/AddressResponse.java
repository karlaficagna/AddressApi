package com.ficagna.addressApi.controller.resourses;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import nonapi.io.github.classgraph.json.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Address")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty
    private Long id;
    @ApiModelProperty("cep_address")
    private String cep;
    @ApiModelProperty("logradouro_address")
    private Integer logradouro;
    @ApiModelProperty("numero_address")
    private Integer complemento;
    @ApiModelProperty("bairro_address")
    private Integer bairro;
    @ApiModelProperty("cidade_address")
    private Integer localidade;
    @ApiModelProperty("uf_address")
    private Integer uf;

    public AddressResponse(Long id) {
    }


}
