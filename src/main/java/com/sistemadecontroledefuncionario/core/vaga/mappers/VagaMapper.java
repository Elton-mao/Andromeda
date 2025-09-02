package com.sistemadecontroledefuncionario.core.vaga.mappers;

import com.sistemadecontroledefuncionario.core.vaga.model.Vaga;
import com.sistemadecontroledefuncionario.web.vagas.dtos.VagaDetalhes;
import com.sistemadecontroledefuncionario.web.vagas.dtos.VagaFormulario;

public interface VagaMapper {

    Vaga toVaga(VagaFormulario vagaFormulario);

    VagaDetalhes toVagaDetalhes(Vaga vaga);
    
}
