package com.sistemadecontroledefuncionario.core.setor.mapper;

import com.sistemadecontroledefuncionario.core.setor.model.Setor;
import com.sistemadecontroledefuncionario.web.setor.dtos.SetorDetalhes;
import com.sistemadecontroledefuncionario.web.setor.dtos.SetorFormulario;

public interface SetorMapper {
        Setor toSetor(SetorFormulario formulario);
        SetorDetalhes toDetalhes(Setor setor);
}
