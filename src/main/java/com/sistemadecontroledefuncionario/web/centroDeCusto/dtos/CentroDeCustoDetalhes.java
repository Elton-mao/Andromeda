package com.sistemadecontroledefuncionario.web.centroDeCusto.dtos;

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
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class CentroDeCustoDetalhes {
    private String id;
    private String codigo;
    private String nome;
    private String descricao;

}
