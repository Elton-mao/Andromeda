package com.sistemadecontroledefuncionario.core.recursosDeTi.Mappers;

import org.springframework.stereotype.Component;

import com.sistemadecontroledefuncionario.core.recursosDeTi.model.RecursoDeTi;
import com.sistemadecontroledefuncionario.web.recursoDeTi.dtos.RecursoDeTiDetalhes;
import com.sistemadecontroledefuncionario.web.recursoDeTi.dtos.RecursoDeTiFormulario;
@Component
public class RecursosDeTiMapperImpl implements RecursoDeTiMapper {

    @Override
    public RecursoDeTiDetalhes toRecursoDeTiDetalhes(RecursoDeTi recursoDeTi) {
        return RecursoDeTiDetalhes.builder()
                .id(recursoDeTi.getId())
                .titulo(recursoDeTi.getTitulo())
                .descricao(recursoDeTi.getDescricao())
                .ativo(recursoDeTi.getAtivo())
                .categoria(recursoDeTi.getCategoriaRecursoTi())
                .build();
    }

    @Override
    public RecursoDeTi toRecursoDeTi(RecursoDeTiFormulario formulario) {
        return RecursoDeTi.builder()
                .titulo(formulario.getTitulo())
                .descricao(formulario.getDescricao())
                .categoriaRecursoTi(formulario.getCategoria())
                .build();
    }

}
