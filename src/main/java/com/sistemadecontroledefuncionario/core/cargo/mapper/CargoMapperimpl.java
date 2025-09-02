package com.sistemadecontroledefuncionario.core.cargo.mapper;

import org.springframework.stereotype.Component;

import com.sistemadecontroledefuncionario.core.cargo.model.Cargo;
import com.sistemadecontroledefuncionario.web.cargo.CargoDetalhes;
import com.sistemadecontroledefuncionario.web.cargo.CargoFormulario;
@Component
public class CargoMapperimpl implements CargoMapper{

    @Override
    public Cargo toCargo(CargoFormulario formulario) {
        return Cargo.builder()
        .tituloDoCargo(formulario.getTituloDoCargo())
        .salario(formulario.getSalario())
        .build();
    }

    @Override
    public CargoDetalhes toCargoDetalhes(Cargo cargo) {
        return CargoDetalhes.builder()
        .id(cargo.getId())
        .tituloDoCargo(cargo.getTituloDoCargo())
        .salario(cargo.getSalario())
        .build();
    }
    
}
