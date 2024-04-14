package com.ficagna.addressApi.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(schema = "Address")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer cep;

    @Column(nullable = false)
    private String logradouro;

    @Column(nullable = false)
    private String complemento;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false)
    private String localidade;

    @Column(nullable = false)
    private String uf;

}

