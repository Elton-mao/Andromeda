package com.sistemadecontroledefuncionario.core.requisicao.mapper;

import com.sistemadecontroledefuncionario.core.requisicao.model.RequisicaoDeTi;
import com.sistemadecontroledefuncionario.web.requisicao.dtos.RequisicaoDeTiDetalhes;
import com.sistemadecontroledefuncionario.web.requisicao.dtos.RequisicaoDeTiFormulario;

public interface RequisicaoDeTiMapper {
    RequisicaoDeTiDetalhes toRequisicaoDeTiDetalhes(RequisicaoDeTi requisicaoDeTi);
    RequisicaoDeTi toRequisicaoDeTi(RequisicaoDeTiFormulario requisicaoDetiFormulario);
}
