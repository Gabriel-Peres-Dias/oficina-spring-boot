package com.oficina.br.controller;

import com.oficina.br.dto.PedidoDTO;
import com.oficina.br.service.PedidoService;
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
@RequestMapping("/pedido")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> buscarPedidoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pedidoService.buscarPedidoPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> buscarTodosPedidos() {
        return ResponseEntity.ok(pedidoService.buscarTodosPedidos());
    }

    @PostMapping
    public ResponseEntity<PedidoDTO> salvarPedido(@RequestBody PedidoDTO pedidoDTO, UriComponentsBuilder uriComponentsBuilder) {
        final var idPedido = pedidoService.salvarPedido(pedidoDTO).getId();
        UriComponents uriComponents = uriComponentsBuilder.path("pedido/{id}").buildAndExpand(idPedido);
        return ResponseEntity.created(uriComponents.toUri()).body(pedidoDTO);
    }

    @PutMapping
    public ResponseEntity<PedidoDTO> editarPedido(@RequestBody PedidoDTO pedidoDTO) {
        return ResponseEntity.ok(pedidoService.editarPedido(pedidoDTO));
    }

    @PutMapping("/ativar/{id}")
    public ResponseEntity<Void> ativarPedido(@PathVariable Long id) {
        pedidoService.ativarPedidoPorId(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/finalizar/{id}")
    public ResponseEntity<Void> finalizarPedido(@PathVariable Long id) {
        pedidoService.finalizarPedido(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelarPedido(@PathVariable Long id) {
        pedidoService.cancelarPedidoPorId(id);
        return ResponseEntity.noContent().build();
    }
}
