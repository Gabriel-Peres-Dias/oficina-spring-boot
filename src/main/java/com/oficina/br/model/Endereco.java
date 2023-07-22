package com.oficina.br.model;

import com.oficina.br.dto.EnderecoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_endereco")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String uf;
    private String cidade;
    private String complemento;

    @OneToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    public Endereco(EnderecoDTO dto, Cliente cliente) {
        this.logradouro = dto.getLogradouro();
        this.bairro = dto.getBairro();
        this.cep = dto.getCep();
        this.numero = dto.getNumero();
        this.uf = dto.getUf();
        this.cidade = dto.getCidade();
        this.complemento = dto.getComplemento();
        this.cliente = cliente;
    }

    public Endereco(EnderecoDTO dto, Funcionario funcionario) {
        this.logradouro = dto.getLogradouro();
        this.bairro = dto.getBairro();
        this.cep = dto.getCep();
        this.numero = dto.getNumero();
        this.uf = dto.getUf();
        this.cidade = dto.getCidade();
        this.complemento = dto.getComplemento();
        this.funcionario = funcionario;
    }
}
