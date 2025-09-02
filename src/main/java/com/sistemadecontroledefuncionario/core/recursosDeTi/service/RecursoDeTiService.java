package com.sistemadecontroledefuncionario.core.recursosDeTi.service;

import java.util.List;

import com.sistemadecontroledefuncionario.core.recursosDeTi.model.RecursoDeTi;
import com.sistemadecontroledefuncionario.web.recursoDeTi.dtos.RecursoDeTiDetalhes;
import com.sistemadecontroledefuncionario.web.recursoDeTi.dtos.RecursoDeTiFormulario;

public interface RecursoDeTiService {
    RecursoDeTiDetalhes buscarPorId(String id);
    List<RecursoDeTi> listarTodosRecursosEntity();
    List<RecursoDeTiDetalhes> listarTodos();
    RecursoDeTiDetalhes criar(RecursoDeTiFormulario formulario);
    RecursoDeTiDetalhes atualizar(String id, RecursoDeTiFormulario formulario);
    void deletar(String id);
}
