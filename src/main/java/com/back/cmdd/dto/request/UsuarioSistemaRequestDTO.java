package com.back.cmdd.dto.request;

import com.back.cmdd.model.Enums.TipoUsuario;

import lombok.Data;

@Data
public class UsuarioSistemaRequestDTO {
    private Long membroId;
    private String senha;
    private TipoUsuario tipoUsuario;
}