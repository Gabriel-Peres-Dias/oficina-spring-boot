package com.oficina.br.model;

import com.oficina.br.dto.PedidoDTO;
import com.oficina.br.enums.StatusServicoEnum;
import com.oficina.br.enums.TipoServicoEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_pedido")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;
    private Long idTipoServico;
    private double valor;
    private LocalDateTime data;
    private Long idTipoStatusServico;

    public Pedido(PedidoDTO pedidoDTO) {
        this.id = pedidoDTO.getId();
        this.cliente = new Cliente(pedidoDTO.getClienteDTO());
        this.funcionario = new Funcionario(pedidoDTO.getFuncionarioDTO());
        this.idTipoServico = pedidoDTO.getIdTipoServico();
        this.valor = pedidoDTO.getValor();
        this.data = pedidoDTO.getData();
        this.idTipoStatusServico = pedidoDTO.getIdTipoStatusServico();
    }
}
