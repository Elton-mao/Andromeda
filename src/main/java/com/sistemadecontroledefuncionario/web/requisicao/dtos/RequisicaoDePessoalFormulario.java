package com.sistemadecontroledefuncionario.web.requisicao.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.sistemadecontroledefuncionario.core.requisicao.enums.MotivoDaRequisicao;
import com.sistemadecontroledefuncionario.core.requisicao.enums.Prioridade;
import com.sistemadecontroledefuncionario.core.requisicao.enums.StatusDaRequisicao;
import com.sistemadecontroledefuncionario.core.requisicao.enums.TipoDeSolicitacao;
import com.sistemadecontroledefuncionario.web.vagas.dtos.VagaFormulario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class RequisicaoDePessoalFormulario {

    private LocalDateTime dataDaAprovacao;

    private LocalDate dataLimiteDaContracao;

    private String centroDeCustoId;

    private int quantidadeDeVagas;

    private StatusDaRequisicao statusDaVaga;

    private String solicitante;

    private VagaFormulario vaga;

    private TipoDeSolicitacao tipoDeSolicitacao;

    private MotivoDaRequisicao motivoDaRequisicao; 

    private Prioridade prioridade;

    private RequisicaoDeTiFormulario requisicaoDeTi;

}