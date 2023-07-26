package com.oficina.br.model;

import com.oficina.br.dto.ClienteDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_cliente")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String senha;
    private String cpf;
    private boolean ativo;

    public Cliente(ClienteDTO dto) {
        if (dto.getId() != null) this.id = dto.getId();
        this.nome = dto.getNome();
        this.email = dto.getEmail();
        this.telefone = dto.getTelefone();
        this.senha = dto.getSenha();
        this.cpf = dto.getCpf();
        this.ativo = dto.isAtivo();
    }
}
