package com.sistemadecontroledefuncionario.core.vaga.enums;

public enum TurnoDeTrabalho {
    PRIMEIRO_TURNO("Primeiro Turno"),
    SEGUNDO_TURNO("Segundo Turno"),
    COMERCIAL("Comercial");

    private final String valor;

    TurnoDeTrabalho(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
