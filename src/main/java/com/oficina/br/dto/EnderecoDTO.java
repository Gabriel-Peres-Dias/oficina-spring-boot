package com.oficina.br.dto;

import com.oficina.br.model.Endereco;
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
public class EnderecoDTO {
    private Long id;
    @NotEmpty(message = "Logradouro é obrigatório.")
    private String logradouro;
    @NotEmpty(message = "Bairro é obrigatório.")
    private String bairro;
    @NotEmpty(message = "CEP é obrigatório.")
    @Length(min = 8, max = 8, message = "O tamanho do CEP deve ser 8.")
    private String cep;
    @NotEmpty(message = "Número é obrigatório.")
    private String numero;
    @NotEmpty(message = "UF é obrigatório.")
    @Length(min = 2, max = 2, message = "O tamanho da UF deve ser 2.")
    private String uf;
    @NotEmpty(message = "Cidade é obrigatório.")
    private String cidade;
    private String complemento;

    public EnderecoDTO(Endereco endereco) {
        if (endereco.getId() != null) this.id = endereco.getId();
        this.logradouro = endereco.getLogradouro();
        this.bairro = endereco.getBairro();
        this.cep = endereco.getCep();
        this.numero = endereco.getNumero();
        this.uf = endereco.getUf();
        this.cidade = endereco.getCidade();
        this.complemento = endereco.getComplemento();
    }
}
