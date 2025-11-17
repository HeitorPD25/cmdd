package com.back.cmdd.dto.response;

import lombok.Data;
import java.time.LocalDateTime;

import com.back.cmdd.model.Enums.TipoUsuario;

@Data
public class UsuarioSistemaResponseDTO {
    private Long id;
    private MembroResponseDTO membro;
    private TipoUsuario tipoUsuario;
    private Boolean ativo;
    private LocalDateTime dataCriacao;
}