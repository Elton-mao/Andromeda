package com.sistemadecontroledefuncionario.core.requisicao.services;

import com.sistemadecontroledefuncionario.web.requisicao.dtos.RequisicaoDePessoalDetalhes;
import com.sistemadecontroledefuncionario.web.requisicao.dtos.RequisicaoDePessoalFormulario;

public interface RequisicaoDePessoalService {
    RequisicaoDePessoalDetalhes criarRequisicaoDePessoal(RequisicaoDePessoalFormulario formulario); 
    

}
