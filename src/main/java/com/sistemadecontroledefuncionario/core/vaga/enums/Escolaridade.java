package com.sistemadecontroledefuncionario.core.vaga.enums;

public enum Escolaridade {
    FUNDAMENTAL("Fundamental"),
    MEDIO("Médio"),
    TECNICO("Técnico"),
    SUPERIOR("Superior"),
    POS_GRADUACAO("Pós-graduação");

    private final String descricao;

    Escolaridade(String descricao) {
        this.descricao = descricao;
    }

    public String getValor() {
        return descricao;
    }
}
