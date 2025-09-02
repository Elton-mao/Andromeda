package com.sistemadecontroledefuncionario.web.vagas.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.sistemadecontroledefuncionario.core.requisicao.model.RequisicaoDePessoal;
import com.sistemadecontroledefuncionario.core.vaga.enums.Cnh;
import com.sistemadecontroledefuncionario.core.vaga.enums.Escolaridade;
import com.sistemadecontroledefuncionario.core.vaga.enums.Isalubridade;
import com.sistemadecontroledefuncionario.core.vaga.enums.PosRequerida;
import com.sistemadecontroledefuncionario.core.vaga.enums.StatusVaga;
import com.sistemadecontroledefuncionario.core.vaga.enums.TipoDeContrato;
import com.sistemadecontroledefuncionario.core.vaga.enums.TurnoDeTrabalho;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;

@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class VagaFormulario {

    private String tituloDoCargo;

    private BigDecimal salario;
    
    private String competenciasTecnicas; 

    private TipoDeContrato tipoDeContrato;

    private TurnoDeTrabalho turnoDeTrabalho;

    private Escolaridade escolaridade;

    private StatusVaga status;

    private LocalDateTime dataCriacao;

    private RequisicaoDePessoal requisicao;

    private Isalubridade isalubridade;

    private Cnh cnhRequerida;
    
    private PosRequerida posRequerida;

    private String cargoId;

}
