package com.oficina.br.controller;

import com.oficina.br.client.viacep.EnderecoResponseDTO;
import com.oficina.br.service.EnderecoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/endereco")
@CrossOrigin(origins = "http://localhost:4200")
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping("/cep/{cep}")
    public ResponseEntity<EnderecoResponseDTO> buscarEnderecoPorCep(@PathVariable String cep) {
        return ResponseEntity.ok(enderecoService.buscarEnderecoPorCep(cep));
    }
}
