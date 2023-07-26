package com.oficina.br.enums;

public enum TipoServicoEnum {
    TIRA_RISCOS(1L, "Tira Riscos"),
    REVITALIZACAO_PINTURA(2L, "Revitalização de pintura"),
    POLIMENTO_CRISTALIZADO(3L, "Polimento Cristalizado"),
    MICRO_PINTURA(4L, "Micro Pintura"),
    POLIMENTO_FAROL(5L, "Polimento de Farol"),
    PINTURA_GERAL(6L, "Pintura geral");

    private final Long id;
    private final String nome;

     TipoServicoEnum(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
         return id;
    }

    public String getNome() {
         return nome;
    }
}
