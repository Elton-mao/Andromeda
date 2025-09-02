package com.sistemadecontroledefuncionario.core.centroDeCusto.mappers;

import com.sistemadecontroledefuncionario.core.centroDeCusto.model.CentroDeCusto;
import com.sistemadecontroledefuncionario.web.centroDeCusto.dtos.CentroDeCustoDetalhes;

public interface CentroDeCustoMapper {
    CentroDeCustoDetalhes toCentroDeCustoDetalhes(CentroDeCusto centroDeCusto);
    
}
