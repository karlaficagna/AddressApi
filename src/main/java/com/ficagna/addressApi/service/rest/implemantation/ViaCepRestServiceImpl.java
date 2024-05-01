package com.ficagna.addressApi.service.rest.implemantation;

import com.ficagna.addressApi.model.dto.ViaCepResponseDTO;
import com.ficagna.addressApi.model.entity.Address;
import com.ficagna.addressApi.service.rest.ExternalCepRestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
public class ViaCepRestServiceImpl implements ExternalCepRestService {

    @Override
    public Address findByCep(Integer cep) {
        RestTemplate restTemplate = new RestTemplate();

        String viaCepUrl = "https://viacep.com.br/ws/" + cep + "/json/";
        ViaCepResponseDTO viaCepResponseDTO = restTemplate.getForObject(viaCepUrl, ViaCepResponseDTO.class);
        if (viaCepResponseDTO != null) {

        }
        return Address.builder()
                .logradouro("Via cep")
                .cep(cep)
                .build();
    }

}
