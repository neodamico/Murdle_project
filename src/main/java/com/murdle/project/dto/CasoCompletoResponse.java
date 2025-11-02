package com.murdle.project.dto;

import lombok.Data;
import java.util.List;

@Data
public class CasoCompletoResponse {
    private Integer id;
    private String titulo;
    private String texto;
    private List<ItemResponse> locais;
    private List<ItemResponse> armas;
    private List<ItemResponse> suspeitos;
    private List<String> dicas;
}