package com.oficina.br.repository;

import com.oficina.br.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    @Modifying
    @Query("UPDATE Funcionario f SET f.ativo = false WHERE f.id = :id")
    void desativarFuncionario(Long id);

    @Query
    Funcionario findFuncionarioByEmailAndSenha(String email, String senha);
}
