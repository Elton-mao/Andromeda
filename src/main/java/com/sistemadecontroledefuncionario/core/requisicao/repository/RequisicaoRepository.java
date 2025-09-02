package com.sistemadecontroledefuncionario.core.requisicao.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemadecontroledefuncionario.core.requisicao.enums.StatusDaRequisicao;
import com.sistemadecontroledefuncionario.core.requisicao.model.Requisicao;

public interface RequisicaoRepository extends JpaRepository<Requisicao, String> {
    List<Requisicao> findBySolicitante_Id(String id);

    List<Requisicao> findByStatusDaRequisicao(StatusDaRequisicao status);


        
    long countBySolicitante_IdAndStatusDaRequisicao(String id, StatusDaRequisicao status);
    
    long countByStatusDaRequisicao(StatusDaRequisicao status);

    List<Requisicao> findByDataDaCriacaoBetween(LocalDateTime dataInicio, LocalDateTime dataFim);
            
}
