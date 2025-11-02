package com.murdle.project.dto;

import lombok.Data;

@Data
public class ValidacaoResponse {
    private boolean acertou;
    private String mensagem;
}