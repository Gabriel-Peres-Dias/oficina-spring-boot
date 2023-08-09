package com.oficina.br.mapper;

import com.oficina.br.dto.ClienteDTO;
import com.oficina.br.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    ClienteDTO toClienteDTO(Cliente cliente);

    Cliente toClienteEntity(ClienteDTO clienteDTO);

}
