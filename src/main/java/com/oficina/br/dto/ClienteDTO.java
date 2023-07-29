package com.oficina.br.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oficina.br.model.Cliente;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private Long id;
    @NotEmpty(message = "Nome é obrigatório.")
    private String nome;
    @NotEmpty(message = "E-mail é obrigatório.")
    @Email(message = "Formato do e-mail inválido")
    private String email;
    @NotEmpty(message = "Telefone é obrigatório.")
    private String telefone;
    @NotEmpty(message = "CPF é obrigatório.")
    private String cpf;
    private boolean ativo;
    @Valid
    @JsonProperty("endereco")
    private EnderecoDTO enderecoDTO;

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
        this.telefone = cliente.getTelefone();
        this.cpf = cliente.getCpf();
        this.ativo = cliente.isAtivo();
    }
}
