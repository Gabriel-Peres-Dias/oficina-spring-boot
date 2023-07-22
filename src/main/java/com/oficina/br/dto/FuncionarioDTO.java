package com.oficina.br.dto;

import com.oficina.br.model.Funcionario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioDTO {
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String matricula;
    private boolean ativo;
    private EnderecoDTO enderecoDTO;

    public FuncionarioDTO(Funcionario funcionario) {
        this.id = funcionario.getId();
        this.nome = funcionario.getNome();
        this.email = funcionario.getEmail();
        this.cpf = funcionario.getCpf();
        this.matricula = funcionario.getMatricula();
        this.ativo = funcionario.isAtivo();
    }
}
