package com.sistemadecontroledefuncionario.core.recursosDeTi.Mappers;

import com.sistemadecontroledefuncionario.core.recursosDeTi.model.RecursoDeTi;
import com.sistemadecontroledefuncionario.web.recursoDeTi.dtos.RecursoDeTiDetalhes;
import com.sistemadecontroledefuncionario.web.recursoDeTi.dtos.RecursoDeTiFormulario;

public interface RecursoDeTiMapper {
    RecursoDeTiDetalhes toRecursoDeTiDetalhes(RecursoDeTi recursoDeTi); 
    RecursoDeTi toRecursoDeTi(RecursoDeTiFormulario formulario);
}
