package com.back.cmdd.dto.response;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class EnderecoResponseDTO {
    private Long id;
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private LocalDateTime dataCadastro;
}