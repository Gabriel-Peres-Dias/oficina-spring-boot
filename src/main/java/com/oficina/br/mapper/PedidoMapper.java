package com.oficina.br.mapper;

import com.oficina.br.dto.PedidoDTO;
import com.oficina.br.model.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PedidoMapper {

    PedidoMapper INSTANCE = Mappers.getMapper(PedidoMapper.class);

    PedidoDTO toPedidoDTO(Pedido pedido);

    Pedido toPedidoEntity(PedidoDTO pedidoDTO);
}
