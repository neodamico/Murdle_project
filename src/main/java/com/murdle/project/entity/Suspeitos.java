package com.murdle.project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.text.DecimalFormat;

@Getter
@Setter

@Entity
@Table(name = "suspeitos")
public class Suspeitos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_suspeito;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "id_casos")
    @JsonBackReference
    private Casos casos;

    private String nome_suspeito;
    private BigDecimal altura_suspeito;
    private String lateralidade;
    private String cor_olhos;
    private String cor_cabelo;

    @Lob
    private String texto_suspeito;
}
