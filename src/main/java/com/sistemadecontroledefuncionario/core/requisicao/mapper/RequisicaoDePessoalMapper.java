package com.sistemadecontroledefuncionario.core.requisicao.mapper;

import com.sistemadecontroledefuncionario.core.requisicao.model.RequisicaoDePessoal;
import com.sistemadecontroledefuncionario.web.requisicao.dtos.RequisicaoDePessoalFormulario;
import com.sistemadecontroledefuncionario.web.requisicao.dtos.RequisicaoDePessoalDetalhes;

public interface RequisicaoDePessoalMapper {

    RequisicaoDePessoal toRequisicaoDePessoal(RequisicaoDePessoalFormulario formulario);
    
    RequisicaoDePessoalDetalhes toRequisicaoDePessoalDetalhes(RequisicaoDePessoal requisicaoDePessoal);

}
