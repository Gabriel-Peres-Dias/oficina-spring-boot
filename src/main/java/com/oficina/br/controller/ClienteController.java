package com.oficina.br.controller;

import com.oficina.br.dto.ClienteDTO;
import com.oficina.br.service.ClienteService;
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
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> buscarTodos(){
        return ResponseEntity.ok(clienteService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> salvar(@RequestBody ClienteDTO clienteDTO, UriComponentsBuilder uriComponentsBuilder) {
        var idCliente = clienteService.salvarCliente(clienteDTO).getId();
        UriComponents uriComponents = uriComponentsBuilder.path("cliente/{id}").buildAndExpand(idCliente);
        return ResponseEntity.created(uriComponents.toUri()).body(clienteDTO);
    }

    @PutMapping
    public ResponseEntity<ClienteDTO> editarCliente(@RequestBody ClienteDTO clienteDTO) {
        return ResponseEntity.ok(clienteService.salvarCliente(clienteDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> desativarCliente(@PathVariable Long id) {
        clienteService.desativarClientePorId(id);
        return ResponseEntity.noContent().build();
    }
}
