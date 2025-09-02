package com.sistemadecontroledefuncionario.web.requisicao.dtos;

import java.time.LocalDateTime;
import java.util.List;

import com.sistemadecontroledefuncionario.web.recursoDeTi.dtos.RecursoDeTiDetalhes;

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
public class RequisicaoDeTiDetalhes {
     private LocalDateTime dataDaAprovacao;
     private List<RecursoDeTiDetalhes> recursos;
    
}
