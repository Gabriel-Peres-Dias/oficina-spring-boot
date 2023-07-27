package com.oficina.br.repository;

import com.oficina.br.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    @Query
    Endereco getEnderecoByClienteId(Long id);

    @Query
    Endereco getEnderecoByFuncionarioId(Long id);
}