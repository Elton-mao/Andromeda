package com.sistemadecontroledefuncionario.core.centroDeCusto.service;

import java.util.List;

import com.sistemadecontroledefuncionario.core.centroDeCusto.model.CentroDeCusto;
import com.sistemadecontroledefuncionario.web.centroDeCusto.dtos.CentroDeCustoDetalhes;

public interface CentroDeCustoService {

    List<CentroDeCustoDetalhes> buscarTodos(); 

    CentroDeCustoDetalhes buscarPorId(String id);

    CentroDeCusto buscarPorIdEntidade(String id);
    
}
