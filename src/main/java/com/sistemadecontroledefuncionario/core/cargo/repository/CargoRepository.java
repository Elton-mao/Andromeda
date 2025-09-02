package com.sistemadecontroledefuncionario.core.cargo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemadecontroledefuncionario.core.cargo.model.Cargo;

public interface CargoRepository  extends JpaRepository<Cargo, String>{
    
}
