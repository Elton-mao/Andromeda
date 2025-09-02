package com.sistemadecontroledefuncionario.core.vaga.enums;

public enum PosRequerida {
    SIM("Sim"),

    NAO("Não");

    private final String descricao;

    PosRequerida(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
