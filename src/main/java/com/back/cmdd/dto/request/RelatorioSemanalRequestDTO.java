package com.back.cmdd.dto.request;

import lombok.Data;
import java.time.LocalDate;

@Data
public class RelatorioSemanalRequestDTO {
    private Long celulaId;
    private LocalDate dataReuniao;
    private Integer totalPresentes;
    private Integer totalVisitantes;
}