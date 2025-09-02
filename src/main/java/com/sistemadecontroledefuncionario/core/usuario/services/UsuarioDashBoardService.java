package com.sistemadecontroledefuncionario.core.usuario.services;

import com.sistemadecontroledefuncionario.web.usuario.dto.DashboardGestor;
import com.sistemadecontroledefuncionario.web.usuario.dto.PainelDoRhDashboard;
import com.sistemadecontroledefuncionario.web.usuario.dto.PainelDoDiretorDashboard;

public interface UsuarioDashBoardService {
     /**
   * Gera o dashboard para o gestor com base no ID do usuário fornecido.
   * 
   * Este método calcula a contagem de requisições por status (em análise, aprovadas e recusadas)
   * para o usuário solicitante e retorna um objeto {@link DashboardGestor} contendo essas informações,
   * além da lista de requisições associadas ao usuário.
   *
   * @param idUsuario o identificador do usuário solicitante
   * @return um objeto {@link DashboardGestor} com as contagens de requisições por status e a lista de requisições
   */
    DashboardGestor gerarDashboardGestor(String idUsuario);

    PainelDoRhDashboard gerarPainelDoRhDashboard(String idUsuario);

    PainelDoDiretorDashboard gerarPainelDoDiretorDashboard(String idUsuario);
    
}
