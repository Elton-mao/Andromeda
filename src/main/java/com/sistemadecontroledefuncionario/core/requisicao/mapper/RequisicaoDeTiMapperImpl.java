package com.sistemadecontroledefuncionario.core.requisicao.mapper;

import org.springframework.stereotype.Component;

import com.sistemadecontroledefuncionario.core.recursosDeTi.Mappers.RecursoDeTiMapper;
import com.sistemadecontroledefuncionario.core.recursosDeTi.Repository.RecursoDeTiRepository;
import com.sistemadecontroledefuncionario.core.requisicao.model.RequisicaoDeTi;
import com.sistemadecontroledefuncionario.web.requisicao.dtos.RequisicaoDeTiDetalhes;
import com.sistemadecontroledefuncionario.web.requisicao.dtos.RequisicaoDeTiFormulario;

import lombok.RequiredArgsConstructor;
@Component
@RequiredArgsConstructor
public class RequisicaoDeTiMapperImpl implements RequisicaoDeTiMapper {    
    private final RecursoDeTiMapper recursoDeTiMapper;
    private final RecursoDeTiRepository recursoDeTiRepository; 
    @Override
    public RequisicaoDeTiDetalhes toRequisicaoDeTiDetalhes(RequisicaoDeTi requisicaoDeTi) {
            var recurso = requisicaoDeTi.getRecursos()
            .stream()
            .map(recursoDeTiMapper::toRecursoDeTiDetalhes)
            .toList();  
            return RequisicaoDeTiDetalhes
                    .builder()
                    .dataDaAprovacao(requisicaoDeTi.getDataDaAprovacao())
                    .recursos(recurso)
                    .build(); 
    }

    @Override
    public RequisicaoDeTi toRequisicaoDeTi(RequisicaoDeTiFormulario requisicaoDetiFormulario) {
        var recursosDeTi = recursoDeTiRepository.findAllById(requisicaoDetiFormulario.getRecursosDeTi());
           return RequisicaoDeTi.builder()
                    .recursos(recursosDeTi)
                    .build();
    }

}
