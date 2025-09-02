package com.sistemadecontroledefuncionario.core.requisicao.mapper;


import com.sistemadecontroledefuncionario.core.requisicao.model.Requisicao;
import com.sistemadecontroledefuncionario.web.requisicao.dtos.RequisicaoDetalhes;


public interface RequisicaoMapper {
    RequisicaoDetalhes toDetalhes(Requisicao requisicao);
}
