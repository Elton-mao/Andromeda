package com.sistemadecontroledefuncionario.core.requisicao.services;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.sistemadecontroledefuncionario.core.vaga.enums.StatusVaga;
import com.sistemadecontroledefuncionario.core.requisicao.enums.TipoDeSolicitacao;
import com.sistemadecontroledefuncionario.core.requisicao.enums.StatusDaRequisicao;
import com.sistemadecontroledefuncionario.core.requisicao.repository.RequisicaoRepository;
import com.sistemadecontroledefuncionario.web.requisicao.dtos.RequisicaoDePessoalDetalhes;
import com.sistemadecontroledefuncionario.core.requisicao.mapper.RequisicaoDePessoalMapper;
import com.sistemadecontroledefuncionario.core.requisicao.mapper.RequisicaoDeTiMapperImpl;
import com.sistemadecontroledefuncionario.web.requisicao.dtos.RequisicaoDePessoalFormulario;

import lombok.RequiredArgsConstructor;
import jakarta.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class RequisicaoDePessoalServiceImpl implements RequisicaoDePessoalService {
    private final RequisicaoRepository requisicaoRepository;
    private final RequisicaoDePessoalMapper requisicaoMapper;
    private final RequisicaoDeTiMapperImpl requisicaoDeTiMapperImpl; 

    @Override
    @Transactional
    public RequisicaoDePessoalDetalhes criarRequisicaoDePessoal(RequisicaoDePessoalFormulario formulario) {
        formulario.getVaga().setStatus(StatusVaga.ABERTA); // TODO: Refatorar este trecho — mover a criação da RequisicaoDePessoal (e suas Vagas) para um factory ou service especializado.
// Isso irá separar responsabilidades e deixar o mapper responsável apenas por conversão simples.
        formulario.setTipoDeSolicitacao(TipoDeSolicitacao.REQUISICAO_DE_PESSOAL);

        var requisicaodeTi = formulario.getRequisicaoDeTi() != null ? 
            requisicaoDeTiMapperImpl.toRequisicaoDeTi(formulario.getRequisicaoDeTi()) :
            null ;
            
        var requisicao = requisicaoMapper.toRequisicaoDePessoal(formulario); 
        requisicao.setRequisicaoDeTi(requisicaodeTi);
        requisicao.setDataDaCriacao(LocalDateTime.now());
        requisicao.setStatusDaRequisicao(StatusDaRequisicao.EM_ANALISE);
        requisicaoRepository.save(requisicao);
        requisicao.getRequisicaoDeTi().setRequisicaoDePessoal(requisicao);
        return requisicaoMapper.toRequisicaoDePessoalDetalhes(requisicao);


    }

}
