package com.oficina.br.controller;

import com.oficina.br.dto.FuncionarioDTO;
import com.oficina.br.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
@CrossOrigin(origins = "http://localhost:4200")
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
    public ResponseEntity<Void> salvarFuncionario(@RequestBody @Valid FuncionarioDTO funcionarioDTO) {
        funcionarioService.salvarFuncionario(funcionarioDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> editarFuncionario(@RequestBody @Valid FuncionarioDTO funcionarioDTO) {
        funcionarioService.salvarFuncionario(funcionarioDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> desativarFuncionario(@PathVariable Long id) {
        funcionarioService.desativarFuncionarioPorId(id);
        return ResponseEntity.noContent().build();
    }
}
