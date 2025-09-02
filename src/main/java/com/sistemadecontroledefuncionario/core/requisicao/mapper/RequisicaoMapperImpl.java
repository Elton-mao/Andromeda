package com.sistemadecontroledefuncionario.core.requisicao.mapper;

import org.springframework.stereotype.Component;

import com.sistemadecontroledefuncionario.core.requisicao.model.Requisicao;
import com.sistemadecontroledefuncionario.core.utils.DateTimeUtils;
import com.sistemadecontroledefuncionario.web.requisicao.dtos.RequisicaoDetalhes;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RequisicaoMapperImpl implements RequisicaoMapper {
;    @Override
    public RequisicaoDetalhes toDetalhes(Requisicao requisicao) {
        return RequisicaoDetalhes.builder()
                .dataDaCriacao(DateTimeUtils.formataDataPadraoBrasileiro(requisicao.getDataDaCriacao()))
                .statusDaRequisicao(requisicao.getStatusDaRequisicao())
                .prioridade(requisicao.getPrioridade())
                .tipoDeSolicitacao(requisicao.getTipoDesolicitacao())
                .nomeDoSolicitante(requisicao.getSolicitante().getNomeCompleto())
                .build();

    }

    
    
}
