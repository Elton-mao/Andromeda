package com.sistemadecontroledefuncionario.web.vagas.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.sistemadecontroledefuncionario.core.requisicao.model.RequisicaoDePessoal;
import com.sistemadecontroledefuncionario.core.vaga.enums.Escolaridade;
import com.sistemadecontroledefuncionario.core.vaga.enums.StatusVaga;
import com.sistemadecontroledefuncionario.core.vaga.enums.TipoDeContrato;
import com.sistemadecontroledefuncionario.core.vaga.enums.TurnoDeTrabalho;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VagaDetalhes {
    
    private String id;

    private String tituloDoCargo;

    private BigDecimal salario;

    private TipoDeContrato tipoDeContrato;

    private TurnoDeTrabalho turnoDeTrabalho;

    private Escolaridade escolaridade;

    private StatusVaga status;

    private LocalDateTime dataCriacao;

    private RequisicaoDePessoal requisicao;
}
