package com.oficina.br.repository;

import com.oficina.br.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Modifying
    @Query("UPDATE Cliente c SET c.ativo = false WHERE c.id = :id")
    void desativarCliente(Long id);
}
