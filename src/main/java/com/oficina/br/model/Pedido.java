package com.oficina.br.model;

import com.oficina.br.enums.ServicoEnum;
import com.oficina.br.enums.StatusServicoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
    private ServicoEnum servicoEnum;
    private double valor;
    private LocalDate data;
    @Enumerated(EnumType.ORDINAL)
    private StatusServicoEnum statusServicoEnum;
}
