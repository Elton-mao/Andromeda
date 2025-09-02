package com.sistemadecontroledefuncionario.core.requisicao.services;

import java.util.List;

import com.sistemadecontroledefuncionario.web.requisicao.dtos.RequisicaoDetalhes;

/**
 * Serviço responsável pelas operações relacionadas às requisições.
 */

public interface RequisicaoService {
    /**
     * Método que retorna todas as requisições.
     *
     * @return uma lista contendo os detalhes de todas as requisições
     */
    List<RequisicaoDetalhes> listarRequisicoes();

       /**
     * Método que retorna todas as requisições POR ID DO SOLICITANTE.
     * @param id o ID do solicitante cujas requisições serão retornadas
     * @return uma lista contendo os detalhes de todas as requisições
     */
    List<RequisicaoDetalhes> listarRequisicoesPorFuncionarioId(String id);
}
