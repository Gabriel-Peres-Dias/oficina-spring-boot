package com.oficina.br.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oficina.br.model.Funcionario;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioDTO {
    private Long id;
    @NotEmpty(message = "Nome é obrigatório.")
    private String nome;
    @NotEmpty(message = "E-mail é obrigatório.")
    @Email(message = "Formato do e-mail inválido.")
    private String email;
    @NotEmpty(message = "CPF é obrigatório.")
    private String cpf;
    @NotEmpty(message = "Matrícula é obrigatória.")
    @Length(min = 5, max = 5, message = "O tamanho da matrícula deve ser 5.")
    private String matricula;
    private boolean ativo;
    @Valid
    @JsonProperty("endereco")
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
