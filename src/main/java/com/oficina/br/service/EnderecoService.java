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
    public EnderecoDTO salvarEndereco(EnderecoDTO enderecoDTO, Cliente cliente, Funcionario funcionario) {
        //TODO: criar uma regra para validacão
        //throw new IllegalArgumentException("Falha ao salvar endereço: enderecoDTO, cliente ou funcionario podem estar nulos");
        log.info("salvando endereco");
        if (Objects.nonNull(cliente) && Objects.nonNull(enderecoDTO)) {
            var endereco = new Endereco(enderecoDTO, cliente);
            var enderecoSalvo = enderecoRepository.save(endereco);
            enderecoDTO.setId(enderecoSalvo.getId());
        } else if(Objects.nonNull(funcionario) && Objects.nonNull(enderecoDTO)) {
            var endereco = new Endereco(enderecoDTO, funcionario);
            var enderecoSalvo = enderecoRepository.save(endereco);
            enderecoDTO.setId(enderecoSalvo.getId());
        }
        return enderecoDTO;
    }
}
