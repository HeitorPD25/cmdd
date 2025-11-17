package com.back.cmdd.dto.request;

import lombok.Data;
import java.time.LocalDate;

@Data
public class VisitanteRequestDTO {
    private String nomeCompleto;
    private String telefone;
    private String email;
    private LocalDate dataVisita;
    private Long celulaId;
    private Long relatorioId;
    private String observacoes;
}