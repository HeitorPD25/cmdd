package com.back.cmdd.dto.response;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class RedeResponseDTO {
    private Long id;
    private String nome;
    private String descricao;
    private UsuarioSistemaResponseDTO coordenador;
    private Boolean ativa;
    private LocalDateTime dataCriacao;
}