package com.murdle.project.dto;

import lombok.Data;

@Data
public class ValidacaoRequest {
    private Integer casoId;
    private Integer localId;
    private Integer armaId;
    private Integer suspeitoId;
}