package com.sistemadecontroledefuncionario.web.usuario.dto;

import java.util.List;

import com.sistemadecontroledefuncionario.web.requisicao.dtos.RequisicaoDetalhes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DashboardGestor {

private Long pendentes;

private Long aprovados;

private Long emAnalise;

private Long recusadas;

private List<RequisicaoDetalhes> requisicoes;

}
