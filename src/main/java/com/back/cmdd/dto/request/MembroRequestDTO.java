package com.back.cmdd.dto.request;

import java.time.LocalDate;

import lombok.Data;

@Data
public class MembroRequestDTO {
    private String nomeCompleto;
    private LocalDate dataNascimento;
    private String telefone;
    private String email;
    private Long enderecoId;
    private String fotoUrl;
    private Long celulaId;
}
