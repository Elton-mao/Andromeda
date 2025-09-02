package com.sistemadecontroledefuncionario.core.vaga.enums;

public enum Cnh {
       SIM("Sim"),
    
    NAO("Não");

    private final String descricao;

    

    Cnh(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
