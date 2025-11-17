package com.back.cmdd.dto.response;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class RelatorioSemanalResponseDTO {
    private Long id;
    private CelulaResponseDTO celula;
    private LocalDate dataReuniao;
    private Integer totalPresentes;
    private Integer totalVisitantes;
    private UsuarioSistemaResponseDTO enviadoPor;
    private LocalDateTime dataEnvio;
}