package com.sistemadecontroledefuncionario.core.setor.mapper;

import org.springframework.stereotype.Component;

import com.sistemadecontroledefuncionario.core.setor.model.Setor;
import com.sistemadecontroledefuncionario.web.setor.dtos.SetorDetalhes;
import com.sistemadecontroledefuncionario.web.setor.dtos.SetorFormulario;
@Component
public class SetorMapperImpl implements SetorMapper{

    @Override
    public Setor toSetor(SetorFormulario formulario) {
        return Setor.builder()
                .nome(formulario.getNome())
                .build();
    }

    @Override
    public SetorDetalhes toDetalhes(Setor setor) {
        return SetorDetalhes.builder()
                .id(setor.getId())
                .nome(setor.getNome())
                .build();
    }
    
}
