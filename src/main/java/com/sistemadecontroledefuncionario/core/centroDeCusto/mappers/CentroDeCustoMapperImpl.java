package com.sistemadecontroledefuncionario.core.centroDeCusto.mappers;

import org.springframework.stereotype.Component;

import com.sistemadecontroledefuncionario.core.centroDeCusto.model.CentroDeCusto;
import com.sistemadecontroledefuncionario.web.centroDeCusto.dtos.CentroDeCustoDetalhes;
@Component
public class CentroDeCustoMapperImpl implements CentroDeCustoMapper{

    @Override
    public CentroDeCustoDetalhes toCentroDeCustoDetalhes(CentroDeCusto centroDecusto) {
        return CentroDeCustoDetalhes.builder()
        .id(centroDecusto.getId())
        .codigo(centroDecusto.getCodigo())
        .nome(centroDecusto.getNome())
        .descricao(centroDecusto.getDescricao()).build();
    }
    
}
