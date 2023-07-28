package com.oficina.br.service;

import com.oficina.br.dto.PedidoDTO;
import com.oficina.br.enums.StatusServicoEnum;
import com.oficina.br.model.Pedido;
import com.oficina.br.repository.PedidoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final EnderecoService enderecoService;

    public PedidoService(PedidoRepository pedidoRepository, EnderecoService enderecoService) {
        this.pedidoRepository = pedidoRepository;
        this.enderecoService = enderecoService;
    }

    @Transactional(readOnly = true)
    public PedidoDTO buscarPedidoPorId(Long id) {
        final var pedido = pedidoRepository.getReferenceById(id);
        return montarPedido(pedido);
    }

    @Transactional(readOnly = true)
    public List<PedidoDTO> buscarTodosPedidos() {
        return pedidoRepository.findAll().stream().map(this::montarPedido).toList();
    }

    @Transactional
    public void salvarPedido(PedidoDTO pedidoDTO) {
        log.info("salvando pedido");
        final var pedido = new Pedido(pedidoDTO);
        pedidoRepository.save(pedido);
    }

    @Transactional
    public void cancelarPedidoPorId(Long id) {
        log.info("cancelando pedido");
        var pedido = pedidoRepository.getReferenceById(id);
        pedido.setIdTipoStatusServico(StatusServicoEnum.CANCELADO.getId());
        pedidoRepository.save(pedido);
    }

    @Transactional
    public void ativarPedidoPorId(Long id) {
        log.info("ativando pedido");
        var pedido = pedidoRepository.getReferenceById(id);
        pedido.setIdTipoStatusServico(StatusServicoEnum.EM_ANDAMENTO.getId());
        pedidoRepository.save(pedido);
    }

    @Transactional
    public void finalizarPedido(Long id) {
        log.info("finalizando pedido");
        var pedido  = pedidoRepository.getReferenceById(id);
        pedido.setIdTipoStatusServico(StatusServicoEnum.FINALIZADO.getId());
        pedidoRepository.save(pedido);
    }

    private PedidoDTO montarPedido(Pedido pedido) {
        var pedidoDTO = new PedidoDTO(pedido);
        montarEndereco(pedidoDTO);
        return pedidoDTO;
    }
    private void montarEndereco(PedidoDTO pedidoDTO) {
        pedidoDTO.getClienteDTO().setEnderecoDTO(enderecoService.buscarEnderecoDeClientePorId(pedidoDTO.getClienteDTO().getId()));
        pedidoDTO.getFuncionarioDTO().setEnderecoDTO(enderecoService.buscarEnderecoDeFuncionarioPorId(pedidoDTO.getFuncionarioDTO().getId()));
    }
}
