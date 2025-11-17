package com.back.cmdd.dto.request;

import java.time.LocalDate;

import lombok.Data;

@Data
public class MembroRequestDTO {
    private String nomeCompleto;
    private LocalDate dataNascimento;
    private String telefone;
    private String email;
    private Long enderecoId;       // Ainda por ID (ou mudamos para nome também?)
    private String fotoUrl;
    private String nomeLider;      // ← NOVO: Nome do líder para encontrar a célula
}
