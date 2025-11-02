package com.murdle.project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "armas")
public class Armas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_armas;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "id_casos")
    @JsonBackReference
    private Casos casos;

    private String nome_armas;
    private String peso;

    @Lob
    private String texto_armas;


}
