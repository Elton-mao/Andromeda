package com.sistemadecontroledefuncionario.web.requisicao.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequisicaoDeTiFormulario {

        private List<String> recursosDeTi;

}
