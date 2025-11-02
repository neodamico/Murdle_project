package com.murdle.project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "locais")
public class Locais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_local;


    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "id_casos")
    @JsonBackReference
    private Casos casos;

    private String nome_local;
    private String tipo_ambiente;

    @Lob
    private String texto_local;
}
