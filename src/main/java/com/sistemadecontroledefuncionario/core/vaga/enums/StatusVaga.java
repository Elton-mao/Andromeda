package com.sistemadecontroledefuncionario.core.vaga.enums;

public enum StatusVaga {
   
    ABERTA("Aberta"),
    PREENCHIDA("Preenchida"),
    CANCELADA("Cancelada");

    private final String valor;

    StatusVaga(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
