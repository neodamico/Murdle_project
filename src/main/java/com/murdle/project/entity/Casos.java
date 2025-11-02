package com.murdle.project.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "casos")
public class Casos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_casos")
    private Integer id_casos;

    @Column(name = "titulo_caso")
    private String titulo_caso;

    @Lob
    private String texto_caso;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "id_local_correto")
    @JsonManagedReference
    private Locais localCorreto;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "id_arma_correta")
    @JsonManagedReference
    private Armas armaCorreta;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_suspeito_correto")
    @JsonManagedReference
    private Suspeitos suspeitoCorreto;

    @ManyToOne (fetch = FetchType.EAGER)
    @JsonManagedReference
    @JoinColumn(name = "id_dicas_para_uso")
    private Dicas dicasParaUso;


}


