package com.oficina.br.dto;

import com.oficina.br.model.Endereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO {
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String uf;
    private String cidade;
    private String complemento;

    public EnderecoDTO(Endereco endereco) {
        this.logradouro = endereco.getLogradouro();
        this.bairro = endereco.getBairro();
        this.cep = endereco.getCep();
        this.numero = endereco.getNumero();
        this.uf = endereco.getUf();
        this.cidade = endereco.getCidade();
        this.complemento = endereco.getComplemento();
    }
}
