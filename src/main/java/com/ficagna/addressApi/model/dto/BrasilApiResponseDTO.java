package com.ficagna.addressApi.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Address")
public class BrasilApiResponseDTO {

    @ApiModelProperty
    private Long id;
    @ApiModelProperty("cep_address")
    private Integer cep;
    @ApiModelProperty("logradouro_address")
    private String street;
    @ApiModelProperty("bairro_address")
    private String neighborhood;
    @ApiModelProperty("cidade_address")
    private String city;
    @ApiModelProperty("uf_address")
    private String state;

}
