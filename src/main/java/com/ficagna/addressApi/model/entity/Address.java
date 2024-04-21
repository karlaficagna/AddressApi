package com.ficagna.addressApi.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(schema = "Address")
@Getter
@Setter
@ToString
@Builder
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
    private Integer numero;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String uf;

}

