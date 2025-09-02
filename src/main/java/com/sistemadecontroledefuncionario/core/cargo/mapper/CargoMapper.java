package com.sistemadecontroledefuncionario.core.cargo.mapper;

import com.sistemadecontroledefuncionario.core.cargo.model.Cargo;
import com.sistemadecontroledefuncionario.web.cargo.CargoDetalhes;
import com.sistemadecontroledefuncionario.web.cargo.CargoFormulario;

public interface CargoMapper {
    Cargo toCargo(CargoFormulario formulario);
    CargoDetalhes toCargoDetalhes(Cargo cargo);
}
