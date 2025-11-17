package com.back.cmdd.dto.request;

import lombok.Data;

@Data
public class EnderecoRequestDTO {
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
}