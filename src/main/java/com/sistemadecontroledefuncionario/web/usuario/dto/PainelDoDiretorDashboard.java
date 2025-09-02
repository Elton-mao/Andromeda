package com.sistemadecontroledefuncionario.web.usuario.dto;

import java.util.List;

import com.sistemadecontroledefuncionario.web.requisicao.dtos.RequisicaoDetalhes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class PainelDoDiretorDashboard {

    private Long totalDeSolicitacoes;

    private Long totalAprovados;

    private Long totalRecusadas;

    private Long totalEmAnalise; 
    
    private List<RequisicaoDetalhes> requisicoesPendentesDeAprovacao;

    private List<RequisicaoDetalhes> historicoDeDecisoes;

}
