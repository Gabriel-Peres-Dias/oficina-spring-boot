package com.oficina.br.mapper;

import com.oficina.br.dto.FuncionarioDTO;
import com.oficina.br.model.Funcionario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FuncionarioMapper {

    FuncionarioMapper INSTANCE = Mappers.getMapper(FuncionarioMapper.class);

    FuncionarioDTO toFuncionarioDTO(Funcionario funcionario);

    Funcionario toFuncinarioEntity(FuncionarioDTO funcionarioDTO);
}
