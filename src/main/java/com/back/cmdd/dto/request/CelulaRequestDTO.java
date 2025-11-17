package com.back.cmdd.dto.request;

import lombok.Data;
import java.time.LocalTime;

@Data
public class CelulaRequestDTO {
    private String nome;
    private Long liderId;
    private Long redeId;
    private Long enderecoId;
    private String diaReuniao;
    private LocalTime horarioReuniao;
}