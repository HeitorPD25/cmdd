package com.back.cmdd.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "relatorios_semanais")
@Data
public class RelatorioSemanal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "celula_id", nullable = false)
    private Celula celula;

    @Column(name = "data_reuniao", nullable = false)
    private LocalDateTime dataReuniao;

    @Column(name = "total_visitantes")
    private Integer totalPresentes = 0;

    @JoinColumn(name = "total_visitantes")
    private Integer totalVisitantes = 0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "enviado_por", nullable = false)
    private UsuarioSistema enviadoPor;

    @Column(name = "data_envio")
    private LocalDateTime dataEnvio = LocalDateTime.now();
}
