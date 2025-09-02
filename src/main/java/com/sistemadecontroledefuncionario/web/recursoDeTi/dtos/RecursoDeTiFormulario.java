package com.sistemadecontroledefuncionario.web.recursoDeTi.dtos;

import com.sistemadecontroledefuncionario.core.recursosDeTi.enums.CategoriaRecursoTi;

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
public class RecursoDeTiFormulario {
    private String titulo;
    private String descricao;
    private CategoriaRecursoTi categoria;

}
