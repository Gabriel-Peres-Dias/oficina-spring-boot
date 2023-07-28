package com.oficina.br.service;

import com.oficina.br.dto.EnderecoDTO;
import com.oficina.br.model.Cliente;
import com.oficina.br.model.Endereco;
import com.oficina.br.model.Funcionario;
import com.oficina.br.repository.EnderecoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Slf4j
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @Transactional(readOnly = true)
    public EnderecoDTO buscarEnderecoPorId(Long id) {
        var endereco = enderecoRepository.getReferenceById(id);
        return new EnderecoDTO(endereco);
    }

    @Transactional
    public void salvarEndereco(EnderecoDTO enderecoDTO, Cliente cliente, Funcionario funcionario) {
        log.info("salvando endereco");
        if (Objects.nonNull(cliente) && Objects.nonNull(enderecoDTO)) {
            var endereco = new Endereco(enderecoDTO, cliente);
            enderecoRepository.save(endereco);
        } else if(Objects.nonNull(funcionario) && Objects.nonNull(enderecoDTO)) {
            var endereco = new Endereco(enderecoDTO, funcionario);
            enderecoRepository.save(endereco);
        }
    }

    @Transactional(readOnly = true)
    public EnderecoDTO buscarEnderecoDeClientePorId(Long idCliente) {
        final var endereco = enderecoRepository.getEnderecoByClienteId(idCliente);
        return new EnderecoDTO(endereco);
    }

    @Transactional(readOnly = true)
    public EnderecoDTO buscarEnderecoDeFuncionarioPorId(Long idFuncionario) {
        final var endereco = enderecoRepository.getEnderecoByFuncionarioId(idFuncionario);
        return new EnderecoDTO(endereco);
    }
}
