package com.sistemadecontroledefuncionario.core.requisicao.enums;

public enum StatusDaRequisicao {

    EM_ANALISE("Em análise"),

    APROVADA("Aprovada"),

    REPROVADA("Reprovada"),

    CANCELADA("Cancelada"),

    PENDENTE_DE_AJUSTE("Pendente de ajuste");

    private final String descricao;

    StatusDaRequisicao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
