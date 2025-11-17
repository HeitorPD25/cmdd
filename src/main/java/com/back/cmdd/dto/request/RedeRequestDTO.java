package com.back.cmdd.dto.request;

import lombok.Data;

@Data
public class RedeRequestDTO {
    private String nome;
    private String descricao;
    private Long coordenadorId;
}