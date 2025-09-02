package com.sistemadecontroledefuncionario.core.vaga.enums;

public enum Isalubridade {

    SIM("Sim"),
    
    NAO("Não");

    private final String descricao;

    

    Isalubridade(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
