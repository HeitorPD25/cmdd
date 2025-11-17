package com.back.cmdd.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.back.cmdd.dto.request.MembroRequestDTO;
import com.back.cmdd.dto.response.MembroResponseDTO;
import com.back.cmdd.model.Celula;
import com.back.cmdd.model.Endereco;
import com.back.cmdd.model.Membro;
import com.back.cmdd.model.UsuarioSistema;
import com.back.cmdd.repository.CelulaRepository;
import com.back.cmdd.repository.EnderecoRepository;
import com.back.cmdd.repository.MembroRepository;
import com.back.cmdd.repository.UsuarioSistemaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MembroService {

    private final MembroRepository membroRepository;
    private final CelulaRepository celulaRepository;
    private final EnderecoRepository enderecoRepository;
    private final UsuarioSistemaRepository usuarioSistemaRepository;

    @Transactional
    public MembroResponseDTO criarMembro(MembroRequestDTO request) {

        // VALIDAÇÃO BÁSICA (NOME OBRIGATÓRIO)
        if (request.getNomeCompleto() == null || request.getNomeCompleto().trim().isEmpty()) {
            throw new RuntimeException("Nome Completo é Obrigatório!");
        }

        // BUSCAR CÉLULA PELO NOME DO LÍDER (SE FOR FORNECIDO)
        Celula celula = null;
        if (request.getNomeLider() != null && !request.getNomeLider().trim().isEmpty()) {
            celula = buscarCelulaPorNomeLider(request.getNomeLider().trim());
        }

        // BUSCAR ENDEREÇO POR ID (SE FORNECIDO)
        Endereco endereco = null;
        if (request.getEnderecoId() != null) {
            endereco = enderecoRepository.findById(request.getEnderecoId())
                .orElseThrow(() -> new RuntimeException(
                    "Endereço não encontrado com ID: " + request.getEnderecoId()
                ));

        }

        // CRIAR E SALVAR MEMBRO
        Membro membro = new Membro();
        membro.setNomeCompleto(request.getNomeCompleto().trim());
        membro.setDataNascimento(request.getDataNascimento());
        membro.setTelefone(request.getTelefone());
        membro.setEmail(request.getEmail());
        membro.setEndereco(endereco);
        membro.setFotoUrl(request.getFotoUrl());
        membro.setCelula(celula);  // Pode ser null se não achou célula

        Membro membroSalvo = membroRepository.save(membro);
        return toResponseDTO(membroSalvo);    
    }

    private Celula buscarCelulaPorNomeLider(String nomeLider) {
        //BUSCAR USUÁRIO PELO NOME (do membro associado)
        UsuarioSistema lider = usuarioSistemaRepository.findAll()
            .stream()
            .filter(usuario -> usuario.getMembro().getNomeCompleto().equalsIgnoreCase(nomeLider))
            .findFirst()
            .orElseThrow(() -> new RuntimeException(
                "Líder não encontrado com o nome: " + nomeLider
            ));

        // BUSCA CÉLULA ONDE O USUÁRIO É LÍDER
        Celula celula = celulaRepository.findAll()
            .stream()
            .filter(c -> c.getLider().getId().equals(lider.getId()))
            .findFirst()
            .orElseThrow(() -> new RuntimeException(
                "Nenhuma célula encontrada para o Líder: " + nomeLider
            ));
        
            return celula;
    }

    // BUSCAR MEMBRO POR ID
    @Transactional(readOnly = true)
    public MembroResponseDTO buscarPorId(Long id) {
        Membro membro = membroRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Membro não encontrado com o ID: " + id));
        return toResponseDTO(membro);
    }

    // LISTAR TODOS OS MEMBROS
    @Transactional(readOnly = true)
    public List<MembroResponseDTO> listarTodos() {
        return membroRepository.findAll()
            .stream()
            .map(this::toResponseDTO)
            .collect(Collectors.toList());
    }

    // MÉTODO PRIVADO DE CONVERSÃO
    private MembroResponseDTO toResponseDTO(Membro membro) {
        MembroResponseDTO response = new MembroResponseDTO();
        response.setId(membro.getId());
        response.setNomeCompleto(membro.getNomeCompleto());
        response.setDataNascimento(membro.getDataNascimento());
        response.setTelefone(membro.getTelefone());
        response.setEmail(membro.getEmail());
        response.setFotoUrl(membro.getFotoUrl());
        response.setStatus(membro.getStatus());
        response.setDataCadastro(membro.getDataCadastro());

        return response;
    }

    
}
