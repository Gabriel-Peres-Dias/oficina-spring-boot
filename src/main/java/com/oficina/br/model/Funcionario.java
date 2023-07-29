package com.oficina.br.model;

import com.oficina.br.dto.FuncionarioDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_funcionario")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String matricula;
    private String senha;
    private boolean ativo;

    public Funcionario(FuncionarioDTO funcionarioDTO) {
        if (funcionarioDTO.getId() != null) this.id = funcionarioDTO.getId();
        this.nome = funcionarioDTO.getNome();
        this.email = funcionarioDTO.getEmail();
        this.cpf = funcionarioDTO.getCpf();
        this.matricula = funcionarioDTO.getMatricula();
        this.senha = funcionarioDTO.getSenha();
        this.ativo = funcionarioDTO.isAtivo();
    }
}
