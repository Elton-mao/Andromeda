package com.sistemadecontroledefuncionario.core.centroDeCusto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistemadecontroledefuncionario.core.centroDeCusto.mappers.CentroDeCustoMapper;
import com.sistemadecontroledefuncionario.core.centroDeCusto.model.CentroDeCusto;
import com.sistemadecontroledefuncionario.core.centroDeCusto.repository.CentroDeCustoRepository;
import com.sistemadecontroledefuncionario.web.centroDeCusto.dtos.CentroDeCustoDetalhes;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class CentroDeCustoServiceImpl implements CentroDeCustoService{
    
    private final CentroDeCustoRepository centroDeCustoRepository;
    private final CentroDeCustoMapper mapper;

    @Override
    public List<CentroDeCustoDetalhes> buscarTodos() {
        return centroDeCustoRepository.findAll()
        .stream()
        .map(mapper::toCentroDeCustoDetalhes)
        .toList(); 
    }

    @Override
    public CentroDeCustoDetalhes buscarPorId(String id) {
        return centroDeCustoRepository.findById(id)
        .map(mapper::toCentroDeCustoDetalhes)
        .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public CentroDeCusto buscarPorIdEntidade(String id) {
       return centroDeCustoRepository.findById(id)
        .orElseThrow(IllegalArgumentException::new);
    }
    
}
