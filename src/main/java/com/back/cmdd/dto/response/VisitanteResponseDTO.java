package com.back.cmdd.dto.response;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class VisitanteResponseDTO {
    private Long id;
    private String nomeCompleto;
    private String telefone;
    private String email;
    private LocalDate dataVisita;
    private CelulaResponseDTO celula;
    private RelatorioSemanalResponseDTO relatorio;
    private String observacoes;
    private LocalDateTime dataCadastro;
}