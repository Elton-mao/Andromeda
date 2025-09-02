package com.sistemadecontroledefuncionario.core.requisicao.enums;

public enum MotivoDaRequisicao {
    CONTRATACAO("Contratação"),
    PROMOCAO("Promoção"),
    AFASTAMENTO_INSS("Afastamento"),
    TRANFERENCIA("Transferência"),
    DESLIGAMENTO("Desligamento"),
    AUMENTO_DE_QUADRO_ORCADO("Aumento De Quadro Orçado"),
    AUMENTO_DE_QUADRO_NAO_ORCADO("Aumento De Quadro não Orçado"),
    SUBSTITUICAO("Substituição");

    private final String descricao;

    MotivoDaRequisicao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
