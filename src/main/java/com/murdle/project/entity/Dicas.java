package com.murdle.project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "dicas")
public class Dicas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_dicas;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "id_casos")
    @JsonBackReference
    private Casos casos;

    @Lob
    private String dica_1;
    @Lob
    private String dica_2;
    @Lob
    private String dica_3;
    @Lob
    private String dica_4;
    @Lob
    private String dica_5;

}
