package com.oficina.br.service;

import com.oficina.br.dto.FuncionarioDTO;
import com.oficina.br.dto.LoginFuncionarioDTO;
import com.oficina.br.mapper.FuncionarioMapper;
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
    public void salvarFuncionario(FuncionarioDTO funcionarioDTO) {
        log.info("salvando funcionario");
        var funcionario = FuncionarioMapper.INSTANCE.toFuncinarioEntity(funcionarioDTO);
        if (funcionario.getId() == null) {
            funcionario.setAtivo(true);
        }

        final var funcionarioSalvo = funcionarioRepository.save(funcionario);
        enderecoService.salvarEndereco(funcionarioDTO.getEnderecoDTO(), null, funcionarioSalvo);
    }

    @Transactional(readOnly = true)
    public FuncionarioDTO logarFuncionario(LoginFuncionarioDTO loginFuncionarioDTO) {
        final var funcionario = funcionarioRepository.findFuncionarioByEmailAndSenha(loginFuncionarioDTO.getEmail(), loginFuncionarioDTO.getSenha());
        return montarFuncionario(funcionario);
    }

    @Transactional
    public void desativarFuncionarioPorId(Long id) {
        funcionarioRepository.desativarFuncionario(id);
    }

    private FuncionarioDTO montarFuncionario(Funcionario funcionario) {
        var funcionarioDTO = FuncionarioMapper.INSTANCE.toFuncionarioDTO(funcionario);
        funcionarioDTO.setEnderecoDTO(enderecoService.buscarEnderecoPorIdFuncionario(funcionarioDTO.getId()));
        return funcionarioDTO;
    }
}
