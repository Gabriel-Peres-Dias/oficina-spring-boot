package com.oficina.br.enums;

public enum StatusServicoEnum {
    EM_ANDAMENTO(1L, "Em andamento"),
    FINALIZADO(2L, "Finalizado"),
    CANCELADO(3L, "Cancelado");

    private final Long id;
    private final String nome;

    StatusServicoEnum(Long id, String nome) {
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
