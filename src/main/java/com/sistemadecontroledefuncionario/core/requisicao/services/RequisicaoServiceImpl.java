package com.sistemadecontroledefuncionario.core.requisicao.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistemadecontroledefuncionario.core.requisicao.mapper.RequisicaoMapper;
import com.sistemadecontroledefuncionario.core.requisicao.repository.RequisicaoRepository;
import com.sistemadecontroledefuncionario.web.requisicao.dtos.RequisicaoDetalhes;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RequisicaoServiceImpl implements RequisicaoService {

    private final RequisicaoMapper mapper;
    private final RequisicaoRepository requisicaoRepository;

    @Override
    public List<RequisicaoDetalhes> listarRequisicoes() {
        return requisicaoRepository.findAll()
                .stream()
                .map(mapper::toDetalhes)
                .toList();
    }

    @Override
    public List<RequisicaoDetalhes> listarRequisicoesPorFuncionarioId(String id) {
        return requisicaoRepository.findBySolicitante_Id(id)
                .stream()
                .map(mapper::toDetalhes)
                .toList();
    }

}
