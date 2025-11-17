package com.back.cmdd.dto.response;

import lombok.Data;
import java.time.LocalTime;
import java.time.LocalDateTime;

@Data
public class CelulaResponseDTO {
    private Long id;
    private String nome;
    private UsuarioSistemaResponseDTO lider;
    private RedeResponseDTO rede;
    private EnderecoResponseDTO endereco;
    private String diaReuniao;
    private LocalTime horarioReuniao;
    private Boolean ativa;
    private LocalDateTime dataCriacao;
}