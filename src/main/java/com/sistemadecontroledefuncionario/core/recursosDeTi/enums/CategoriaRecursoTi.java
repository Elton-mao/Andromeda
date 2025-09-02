package com.sistemadecontroledefuncionario.core.recursosDeTi.enums;

public enum CategoriaRecursoTi {

    HARDWARE("Hardware"),
    SOFTWARE("Software"),
    ACESSO("Acesso"),
    COMUNICACAO("Comunicação");

    private final String descricao;

    CategoriaRecursoTi(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
