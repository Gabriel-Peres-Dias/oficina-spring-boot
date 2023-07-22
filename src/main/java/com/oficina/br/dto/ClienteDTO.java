package com.oficina.br.dto;

import com.oficina.br.model.Cliente;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteDTO {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String senha;
    private String cpf;
    private boolean ativo;
    private EnderecoDTO enderecoDTO;

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
        this.telefone = cliente.getTelefone();
        this.senha = cliente.getSenha();
        this.cpf = cliente.getCpf();
        this.ativo = cliente.isAtivo();
    }
}
