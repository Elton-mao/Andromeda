package com.sistemadecontroledefuncionario.core.requisicao.services;

import com.sistemadecontroledefuncionario.core.requisicao.mapper.RequisicaoMapper;
import com.sistemadecontroledefuncionario.core.requisicao.repository.RequisicaoRepository;
import com.sistemadecontroledefuncionario.web.requisicao.dtos.RequisicaoDetalhes;
// import com.sistemadecontroledefuncionario.core.requisicao.entities.Requisicao;

import com.sistemadecontroledefuncionario.core.requisicao.model.Requisicao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;




class RequisicaoServiceImplTest {

    private RequisicaoRepository requisicaoRepository;
    private RequisicaoMapper requisicaoMapper;
    private RequisicaoServiceImpl requisicaoService;

    @BeforeEach
    void setUp() {
        requisicaoRepository = mock(RequisicaoRepository.class);
        requisicaoMapper = mock(RequisicaoMapper.class);
        requisicaoService = new RequisicaoServiceImpl(requisicaoMapper, requisicaoRepository);
    }

    @Test
    void listarRequisicoes_returnsMappedList_whenRepositoryReturnsEntities() {
        Requisicao req1 = mock(Requisicao.class);
        Requisicao req2 = mock(Requisicao.class);
        List<Requisicao> requisicoes = Arrays.asList(req1, req2);

        RequisicaoDetalhes detalhes1 = new RequisicaoDetalhes();
        RequisicaoDetalhes detalhes2 = new RequisicaoDetalhes();

        when(requisicaoRepository.findAll()).thenReturn(requisicoes);
        when(requisicaoMapper.toDetalhes(req1)).thenReturn(detalhes1);
        when(requisicaoMapper.toDetalhes(req2)).thenReturn(detalhes2);

        List<RequisicaoDetalhes> result = requisicaoService.listarRequisicoes();

        assertEquals(2, result.size());
        assertTrue(result.contains(detalhes1));
        assertTrue(result.contains(detalhes2));
        verify(requisicaoRepository, times(1)).findAll();
        verify(requisicaoMapper, times(1)).toDetalhes(req1);
        verify(requisicaoMapper, times(1)).toDetalhes(req2);
    }

    @Test
    void listarRequisicoes_returnsEmptyList_whenRepositoryReturnsEmpty() {
        when(requisicaoRepository.findAll()).thenReturn(Collections.emptyList());

        List<RequisicaoDetalhes> result = requisicaoService.listarRequisicoes();

        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(requisicaoRepository, times(1)).findAll();
        verifyNoInteractions(requisicaoMapper);
    }
}