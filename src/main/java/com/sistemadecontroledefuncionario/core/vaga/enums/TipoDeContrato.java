package com.sistemadecontroledefuncionario.core.vaga.enums;

public enum TipoDeContrato {
    EFETIVO("Efetivo"),
    INTERMITENTE("Intermitente"),
    ESTAGIO("Estágio"),
    JOVEM_APRENDIZ("Jovem Aprendiz"),
    PJ("Pessoa Juridíca");

    private final String valor;

    TipoDeContrato(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}


