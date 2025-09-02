package com.sistemadecontroledefuncionario.core.recursosDeTi.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.sistemadecontroledefuncionario.core.recursosDeTi.Mappers.RecursoDeTiMapper;
import com.sistemadecontroledefuncionario.core.recursosDeTi.Repository.RecursoDeTiRepository;
import com.sistemadecontroledefuncionario.core.recursosDeTi.model.RecursoDeTi;
import com.sistemadecontroledefuncionario.web.recursoDeTi.dtos.RecursoDeTiDetalhes;
import com.sistemadecontroledefuncionario.web.recursoDeTi.dtos.RecursoDeTiFormulario;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecursoDeTiServiceImpl implements RecursoDeTiService {
    private final RecursoDeTiRepository recursoDeTiRepository;
    private final RecursoDeTiMapper recursoDeTiMapper;
    

    @Override
    public RecursoDeTiDetalhes buscarPorId(String id) {
        return recursoDeTiRepository.findById(id)
                .map(recursoDeTiMapper::toRecursoDeTiDetalhes)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<RecursoDeTiDetalhes> listarTodos() {
        return recursoDeTiRepository.findAll()
                .stream()
                .map(recursoDeTiMapper::toRecursoDeTiDetalhes)
                .toList();
    }

    @Override
    public RecursoDeTiDetalhes criar(RecursoDeTiFormulario formulario) {
        var recursoDeTi = recursoDeTiMapper.toRecursoDeTi(formulario);
        recursoDeTi.setAtivo(true);
        recursoDeTi = recursoDeTiRepository.save(recursoDeTi);
        return recursoDeTiMapper.toRecursoDeTiDetalhes(recursoDeTi);
    }

    @Override
    public RecursoDeTiDetalhes atualizar(String id, RecursoDeTiFormulario formulario) {
        var recursoDeTi = recursoDeTiRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        BeanUtils.copyProperties(formulario, recursoDeTi);
        recursoDeTi = recursoDeTiRepository.save(recursoDeTi);
        return recursoDeTiMapper.toRecursoDeTiDetalhes(recursoDeTi);
    }

    @Override
    public void deletar(String id) {
        var recursoDeTi = recursoDeTiRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        recursoDeTiRepository.delete(recursoDeTi);
    }

    @Override
    public List<RecursoDeTi> listarTodosRecursosEntity() {
        return recursoDeTiRepository.findAll();
    }

}
