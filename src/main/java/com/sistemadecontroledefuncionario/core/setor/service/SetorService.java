package com.sistemadecontroledefuncionario.core.setor.service;

import java.util.List;

import com.sistemadecontroledefuncionario.web.setor.dtos.SetorDetalhes;
import com.sistemadecontroledefuncionario.web.setor.dtos.SetorFormulario;

public interface SetorService {
    void Cadastrar(SetorFormulario formulario);
    SetorDetalhes buscarPorId(String id);
    List<SetorDetalhes> buscarTodosSetores(); 

    
}
