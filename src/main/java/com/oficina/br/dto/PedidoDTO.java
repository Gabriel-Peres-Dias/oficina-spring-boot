package com.oficina.br.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.oficina.br.enums.StatusServicoEnum;
import com.oficina.br.enums.TipoServicoEnum;
import com.oficina.br.model.Pedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {

    private Long id;
    private ClienteDTO clienteDTO;
    private FuncionarioDTO funcionarioDTO;
    private Long idTipoServico;
    private double valor;
    @JsonDeserialize(as = LocalDateTime.class)
    private LocalDateTime data;
    private Long idTipoStatusServico;

    public PedidoDTO(Pedido pedido) {
        this.id = pedido.getId();
        this.clienteDTO = new ClienteDTO(pedido.getCliente());
        this.funcionarioDTO = new FuncionarioDTO(pedido.getFuncionario());
        this.idTipoServico = pedido.getIdTipoServico();
        this.valor = pedido.getValor();
        this.data = pedido.getData();
        this.idTipoStatusServico = pedido.getIdTipoStatusServico();
    }
}
