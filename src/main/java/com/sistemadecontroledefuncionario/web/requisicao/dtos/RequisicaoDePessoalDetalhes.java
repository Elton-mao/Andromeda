package com.sistemadecontroledefuncionario.web.requisicao.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.sistemadecontroledefuncionario.core.requisicao.enums.StatusDaRequisicao;
import com.sistemadecontroledefuncionario.core.usuario.model.Usuario;
import com.sistemadecontroledefuncionario.core.vaga.model.Vaga;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequisicaoDePessoalDetalhes {

    private  String id;

    private LocalDate date;

    private String centroDeCusto;

    private int quantidadeDeVagas;

    private StatusDaRequisicao StatusDaVaga;

    private String solicitanteId;

    private LocalDateTime dataDacriacao;

    private LocalDateTime dataDaAprovacao;

    private Usuario solicitante;

    private List<Vaga> vagas;

}
