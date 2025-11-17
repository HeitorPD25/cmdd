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
@Table(name = "celulas")
@Data
public class Celula {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long celulaId;

    @Column(nullable = false, length = 255)
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rede_id", nullable = false)
    private UsuarioSistema lider;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @Column(name = "dia_reuniao", length = 50)
    private String diaReuniao;

    @Column(name = "horario_reuniao")
    private LocalDateTime horarioReuniao;

    @Column(nullable = false)
    private Boolean ativa = true;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao = LocalDateTime.now();
}
