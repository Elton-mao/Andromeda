package com.sistemadecontroledefuncionario.core.usuario.services;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sistemadecontroledefuncionario.core.requisicao.enums.StatusDaRequisicao;
import com.sistemadecontroledefuncionario.core.requisicao.mapper.RequisicaoMapper;
import com.sistemadecontroledefuncionario.core.requisicao.repository.RequisicaoRepository;
import com.sistemadecontroledefuncionario.web.usuario.dto.DashboardGestor;
import com.sistemadecontroledefuncionario.web.usuario.dto.PainelDoRhDashboard;
import com.sistemadecontroledefuncionario.web.usuario.dto.PainelDoDiretorDashboard;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioDashBoardServiceImpl implements UsuarioDashBoardService {
    private final RequisicaoRepository requisicaoRepository;
    private final RequisicaoMapper mapper;

    /**
     * Retorna um mapa contendo a contagem de solicitações por status
     * para o usuário informado.
     *
     * @param idUsuario ID do usuário solicitante
     * @return Mapa com o total por StatusDaRequisicao
     */
    private Map<StatusDaRequisicao, Long> cotagemPorStatusEIdDoRequisitante(String idUsuario) {
        return Arrays.stream(StatusDaRequisicao.values())
                .collect(Collectors.toMap(
                        status -> status,
                        status -> requisicaoRepository.countBySolicitante_IdAndStatusDaRequisicao(idUsuario, status)));
    }

    @Override
    public DashboardGestor gerarDashboardGestor(String idUsuario) {

        var contagem = cotagemPorStatusEIdDoRequisitante(idUsuario);

        var requisicoes = requisicaoRepository.findBySolicitante_Id(idUsuario)
                .stream()
                .map(mapper::toDetalhes)
                .toList();
        return DashboardGestor.builder()
                .emAnalise(contagem.getOrDefault(StatusDaRequisicao.EM_ANALISE, 0L))
                .aprovados(contagem.getOrDefault(StatusDaRequisicao.APROVADA, 0L))
                .recusadas(contagem.getOrDefault(StatusDaRequisicao.REPROVADA, 0L))
                .requisicoes(requisicoes)
                .build();
    }

    @Override
    public PainelDoRhDashboard gerarPainelDoRhDashboard(String idUsuario) {
        var agora = LocalDateTime.now();
        var inicioDoMes = agora.withDayOfMonth(1);

        var totalDerequisicoes = requisicaoRepository.count();

        var requisicaoRecentes = requisicaoRepository
                .findByDataDaCriacaoBetween(inicioDoMes, agora)
                .stream()
                .map(mapper::toDetalhes)
                .toList();

        return PainelDoRhDashboard.builder()
                .totalDeSolicitações(totalDerequisicoes)
                .emAnalise(requisicaoRepository.countByStatusDaRequisicao(StatusDaRequisicao.EM_ANALISE))
                .aprovados(requisicaoRepository.countByStatusDaRequisicao(StatusDaRequisicao.APROVADA))
                .recusadas(requisicaoRepository.countByStatusDaRequisicao(StatusDaRequisicao.REPROVADA))
                .pendenteDeAjustes(
                        requisicaoRepository.countByStatusDaRequisicao(StatusDaRequisicao.PENDENTE_DE_AJUSTE))
                .requisicoesRecentes(requisicaoRecentes)
                .build();
    }

    @Override
    public PainelDoDiretorDashboard gerarPainelDoDiretorDashboard(String idUsuario) {
        var totalDerequisicoes = requisicaoRepository.count();

        var contagem = cotagemPorStatusEIdDoRequisitante(idUsuario);

        var requisicaoPendentes = requisicaoRepository.findByStatusDaRequisicao(StatusDaRequisicao.EM_ANALISE)
                .stream()
                .map(mapper::toDetalhes)
                .toList();

        var historicoDeDecisoes = requisicaoRepository.findByStatusDaRequisicao(StatusDaRequisicao.APROVADA)
                .stream()
                .map(mapper::toDetalhes)
                .toList();

        return PainelDoDiretorDashboard.builder()
                .totalDeSolicitacoes(totalDerequisicoes)
                .totalAprovados(contagem.getOrDefault(StatusDaRequisicao.APROVADA, 0L))
                .totalRecusadas(contagem.getOrDefault(StatusDaRequisicao.REPROVADA, 0L))
                .totalEmAnalise(contagem.getOrDefault(StatusDaRequisicao.EM_ANALISE, 0L))
                .requisicoesPendentesDeAprovacao(requisicaoPendentes)
                .historicoDeDecisoes(historicoDeDecisoes)
                .build();
    }

}
