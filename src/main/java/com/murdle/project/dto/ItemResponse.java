package com.murdle.project.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ItemResponse {
    private Integer id;
    private String nome;
    private String texto;
    private BigDecimal altura;
    private String lateralidade ;
    private String cor_olhos;
    private String cor_cabelo;
    private String extra;

}