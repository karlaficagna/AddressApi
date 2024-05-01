package com.ficagna.addressApi.service.rest.implemantation;


import com.ficagna.addressApi.model.entity.Address;
import com.ficagna.addressApi.service.rest.ExternalCepRestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
@RequiredArgsConstructor
@Slf4j
public class CepAbertoServiceImpl implements ExternalCepRestService {

    @Override
    public Address findByCep(Integer cep) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.cepaberto.com/api/v3/cep?cep=01001000";
        String token = "ccd3286cae1f00ffc258a119609f57a5";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestProperty("Authorization", "Token token=" + token);
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        return Address.builder()
                .logradouro("Cep Aberto")
                .cep(cep)
                .build();

    }
}
