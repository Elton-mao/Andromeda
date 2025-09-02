package com.sistemadecontroledefuncionario.core.requisicao.enums;

public enum TipoDeSolicitacao {
    REQUISICAO_DE_PESSOAL("Requisição de Pessoal");
    
    private final String descricao;

    TipoDeSolicitacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
