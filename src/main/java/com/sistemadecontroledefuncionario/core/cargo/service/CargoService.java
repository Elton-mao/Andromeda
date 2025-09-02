package com.sistemadecontroledefuncionario.core.cargo.service;

import java.util.List;

import com.sistemadecontroledefuncionario.core.cargo.model.Cargo;
import com.sistemadecontroledefuncionario.web.cargo.CargoDetalhes;
import com.sistemadecontroledefuncionario.web.cargo.CargoFormulario;

public interface CargoService {
    void criarCargo(CargoFormulario formulario);
    void editarCargo(String id, CargoFormulario formulario);
    void excluirCargo(String id);
    CargoDetalhes buscarPorId(String id);
    Cargo buscarPorIdEntidade(String id);
    List<CargoDetalhes> buscarTodosOsCargos();
}
