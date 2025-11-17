package com.back.cmdd.dto.response;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.back.cmdd.model.Enums.StatusMembro;

@Data
public class MembroResponseDTO {
    private Long id;
    private String nomeCompleto;
    private LocalDate dataNascimento;
    private String telefone;
    private String email;
    private EnderecoResponseDTO endereco;
    private String fotoUrl;
    private CelulaResponseDTO celula;
    private StatusMembro status;
    private LocalDateTime dataCadastro;
}