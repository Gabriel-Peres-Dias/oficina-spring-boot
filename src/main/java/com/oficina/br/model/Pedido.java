package com.oficina.br.model;

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
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "id_tipo_servico")
    private TipoServicoEnum tipoServicoEnum;
    private double valor;
    private LocalDateTime data;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "id_status_servico")
    private StatusServicoEnum statusServicoEnum;
}
