package com.oficina.br.service;

import com.oficina.br.dto.EnderecoDTO;
import com.oficina.br.mapper.EnderecoMapper;
import com.oficina.br.model.Cliente;
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
    public EnderecoDTO buscarEnderecoPorIdFuncionario(Long id) {
        final var endereco = enderecoRepository.getEnderecoByFuncionarioId(id);
        return EnderecoMapper.INSTANCE.toEnderecoDTO(endereco);
    }

    @Transactional(readOnly = true)
    public EnderecoDTO buscarEnderecoPorIdCliente(Long id) {
        final var endereco = enderecoRepository.getEnderecoByClienteId(id);
        return EnderecoMapper.INSTANCE.toEnderecoDTO(endereco);
    }

    @Transactional
    public void salvarEndereco(EnderecoDTO enderecoDTO, Cliente cliente, Funcionario funcionario) {
        log.info("salvando endereco");
        if (Objects.nonNull(cliente) && Objects.nonNull(enderecoDTO)) {
            final var endereco = EnderecoMapper.INSTANCE.toEnderecoEntity(enderecoDTO);
            endereco.setCliente(cliente);
            enderecoRepository.save(endereco);
        } else if (Objects.nonNull(funcionario) && Objects.nonNull(enderecoDTO)) {
            final var endereco = EnderecoMapper.INSTANCE.toEnderecoEntity(enderecoDTO);
            endereco.setFuncionario(funcionario);
            enderecoRepository.save(endereco);
        }
    }

    @Transactional(readOnly = true)
    public EnderecoDTO buscarEnderecoDeClientePorId(Long idCliente) {
        final var endereco = enderecoRepository.getEnderecoByClienteId(idCliente);
        return EnderecoMapper.INSTANCE.toEnderecoDTO(endereco);
    }

    @Transactional(readOnly = true)
    public EnderecoDTO buscarEnderecoDeFuncionarioPorId(Long idFuncionario) {
        final var endereco = enderecoRepository.getEnderecoByFuncionarioId(idFuncionario);
        return EnderecoMapper.INSTANCE.toEnderecoDTO(endereco);
    }
}
