package com.sistemadecontroledefuncionario.core.cargo.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.sistemadecontroledefuncionario.core.cargo.mapper.CargoMapper;
import com.sistemadecontroledefuncionario.core.cargo.model.Cargo;
import com.sistemadecontroledefuncionario.core.cargo.repository.CargoRepository;
import com.sistemadecontroledefuncionario.web.cargo.CargoDetalhes;
import com.sistemadecontroledefuncionario.web.cargo.CargoFormulario;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CargoServiceImpl implements CargoService {
    private final CargoRepository cargoRepository;
    private final CargoMapper mapper;

    @Override
    public void criarCargo(CargoFormulario formulario) {
        var cargo = mapper.toCargo(formulario);
        cargoRepository.save(cargo);
    }

    @Override
    public void editarCargo(String id, CargoFormulario formulario) {
        var cargoEditado = cargoRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        BeanUtils.copyProperties(formulario, cargoEditado, "id");
        cargoRepository.save(cargoEditado);

    }

    @Override
    public void excluirCargo(String id) {
        if (cargoRepository.existsById(id)) {
            cargoRepository.deleteById(id);
        }
    }

    @Override
    public CargoDetalhes buscarPorId(String id) {
        return cargoRepository.findById(id)
        .map(mapper::toCargoDetalhes)
        .orElseThrow(IllegalArgumentException::new);
        
    }

	@Override
	public List<CargoDetalhes> buscarTodosOsCargos() {
		return cargoRepository.findAll()
        .stream()
        .map(mapper::toCargoDetalhes)
        .toList(); 
	}

    @Override
    public Cargo buscarPorIdEntidade(String id) {
       return cargoRepository.findById(id)
               .orElseThrow(IllegalArgumentException::new); 
    }

}
