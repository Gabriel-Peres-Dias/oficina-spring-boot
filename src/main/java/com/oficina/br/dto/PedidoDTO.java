package com.oficina.br.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.oficina.br.enums.StatusServicoEnum;
import com.oficina.br.enums.TipoServicoEnum;
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
    private Long idCliente;
    private Long idFuncionario;
    private TipoServicoEnum tipoServicoEnum;
    private double valor;
    @JsonDeserialize(as = LocalDateTime.class)
    private LocalDateTime data;
    private StatusServicoEnum statusServicoEnum;
}
