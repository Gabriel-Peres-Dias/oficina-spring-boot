package com.oficina.br.controller;

import com.oficina.br.dto.PedidoDTO;
import com.oficina.br.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Void> salvarPedido(@RequestBody @Valid PedidoDTO pedidoDTO) {
        pedidoService.salvarPedido(pedidoDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> editarPedido(@RequestBody @Valid PedidoDTO pedidoDTO) {
        pedidoService.salvarPedido(pedidoDTO);
        return ResponseEntity.noContent().build();
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
