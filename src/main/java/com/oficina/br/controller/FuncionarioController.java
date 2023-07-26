package com.oficina.br.controller;

import com.oficina.br.dto.FuncionarioDTO;
import com.oficina.br.service.FuncionarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> buscarFuncionarioPorId(@PathVariable Long id) {
        return ResponseEntity.ok(funcionarioService.consultarFuncionarioPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<FuncionarioDTO>> buscarTodosFuncionarios() {
        return ResponseEntity.ok(funcionarioService.buscarTodosFuncionarios());
    }

    @PostMapping
    public ResponseEntity<FuncionarioDTO> salvarFuncionario(@RequestBody FuncionarioDTO funcionarioDTO, UriComponentsBuilder uriComponentsBuilder) {
        var idFuncionario = funcionarioService.salvarFuncionario(funcionarioDTO).getId();
        UriComponents uriComponents = uriComponentsBuilder.path("funcionario/{id}").buildAndExpand(idFuncionario);
        return ResponseEntity.created(uriComponents.toUri()).body(funcionarioDTO);
    }

    @PutMapping
    public ResponseEntity<FuncionarioDTO> editarFuncionario(@RequestBody FuncionarioDTO funcionarioDTO) {
        return ResponseEntity.ok(funcionarioService.salvarFuncionario(funcionarioDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> desativarFuncionario(@PathVariable Long id) {
        funcionarioService.desativarFuncionarioPorId(id);
        return ResponseEntity.noContent().build();
    }
}
