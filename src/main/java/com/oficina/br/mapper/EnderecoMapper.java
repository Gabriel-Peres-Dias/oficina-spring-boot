package com.oficina.br.mapper;

import com.oficina.br.dto.ClienteDTO;
import com.oficina.br.dto.EnderecoDTO;
import com.oficina.br.dto.FuncionarioDTO;
import com.oficina.br.model.Cliente;
import com.oficina.br.model.Endereco;
import com.oficina.br.model.Funcionario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EnderecoMapper {

    EnderecoMapper INSTANCE = Mappers.getMapper(EnderecoMapper.class);

    EnderecoDTO toEnderecoDTO(Endereco endereco);

    Endereco toEnderecoEntity(EnderecoDTO enderecoDTO);

    FuncionarioDTO toFuncionarioDTO(Funcionario funcionario);

    Funcionario toFuncionarioEntity(FuncionarioDTO funcionarioDTO);

    ClienteDTO toClienteDTO(Cliente cliente);

    Cliente toClienteEntity(ClienteDTO clienteDTO);
}
