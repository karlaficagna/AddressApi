package com.ficagna.addressApi.model.entity;

import lombok.*;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {

    private Long id;
    private Integer cep;
    private String logradouro;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String uf;

    public AddressDto(Address address) {
    }

    public static List<AddressDto> converterParaEntity(List<Address> address) {
        return address
                .stream()
                .map(com.ficagna.addressApi.model.entity.AddressDto::new)
                .collect(Collectors.toList());
    }


}

