package com.oficina.br.service;

import com.oficina.br.dto.FuncionarioDTO;
import com.oficina.br.model.Funcionario;
import com.oficina.br.repository.FuncionarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final EnderecoService enderecoService;

    public FuncionarioService(FuncionarioRepository funcionarioRepository, EnderecoService enderecoService) {
        this.funcionarioRepository = funcionarioRepository;
        this.enderecoService = enderecoService;
    }

    @Transactional(readOnly = true)
    public FuncionarioDTO consultarFuncionarioPorId(Long id) {
        var funcionario = funcionarioRepository.getReferenceById(id);
        return montarFuncionario(funcionario);
    }

    @Transactional(readOnly = true)
    public List<FuncionarioDTO> buscarTodosFuncionarios() {
        var lista = funcionarioRepository.findAll();
        return lista.stream().map(this::montarFuncionario).toList();
    }

    @Transactional
    public FuncionarioDTO salvarFuncionario(FuncionarioDTO funcionarioDTO) {
        log.info("salvando funcionario");
        var funcionario = new Funcionario(funcionarioDTO);
        if (funcionario.getId() == null) {
            funcionario.setAtivo(true);
        }

        var funcionarioSalvo = funcionarioRepository.save(funcionario);
        funcionarioDTO.setId(funcionarioSalvo.getId());
        funcionarioDTO.setAtivo(funcionarioSalvo.isAtivo());
        funcionarioDTO.getEnderecoDTO().setId((enderecoService.salvarEndereco(funcionarioDTO.getEnderecoDTO(), null, funcionarioSalvo).getId()));
        return funcionarioDTO;
    }

    @Transactional
    public void desativarFuncionarioPorId(Long id) {
        funcionarioRepository.desativarFuncionario(id);
    }

    private FuncionarioDTO montarFuncionario(Funcionario funcionario) {
        var funcionarioDTO = new FuncionarioDTO(funcionario);
        funcionarioDTO.setEnderecoDTO(enderecoService.buscarEnderecoPorId(funcionarioDTO.getId()));
        return funcionarioDTO;
    }
}
