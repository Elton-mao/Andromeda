package com.sistemadecontroledefuncionario.web.requisicao.dtos;

import com.sistemadecontroledefuncionario.core.requisicao.enums.Prioridade;
import com.sistemadecontroledefuncionario.core.requisicao.enums.StatusDaRequisicao;
import com.sistemadecontroledefuncionario.core.requisicao.enums.TipoDeSolicitacao;

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
@AllArgsConstructor
@EqualsAndHashCode
public class RequisicaoDetalhes {

        private String dataDaCriacao;

        private StatusDaRequisicao statusDaRequisicao;

        private Prioridade prioridade;

        private TipoDeSolicitacao tipoDeSolicitacao;
        
        private String nomeDoSolicitante;

}
