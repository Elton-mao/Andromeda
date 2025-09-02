package com.sistemadecontroledefuncionario.core.vaga.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemadecontroledefuncionario.core.vaga.model.Vaga;

public interface VagaRepository extends JpaRepository< Vaga, String> {
    
}
