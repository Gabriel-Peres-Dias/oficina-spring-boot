package com.oficina.br.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.oficina.br.enums.StatusServicoEnum;
import com.oficina.br.enums.TipoServicoEnum;
import com.oficina.br.model.Pedido;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
    @Valid
    private ClienteDTO clienteDTO;
    @Valid
    private FuncionarioDTO funcionarioDTO;
    @NotNull(message = "O tipo de serviço é obrigatório.")
    private Long idTipoServico;
    @NotNull(message = "O valor é obrigatório.")
    private double valor;
    @JsonDeserialize(as = LocalDateTime.class)
    @NotNull(message = "A data deve ser obrigatória.")
    private LocalDateTime data;
    @NotNull(message = "O tipo de status do serviço é obrigatório.")
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
