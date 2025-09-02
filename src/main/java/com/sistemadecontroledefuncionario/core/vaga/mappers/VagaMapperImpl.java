package com.sistemadecontroledefuncionario.core.vaga.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.sistemadecontroledefuncionario.core.vaga.model.Vaga;
import com.sistemadecontroledefuncionario.web.vagas.dtos.VagaDetalhes;
import com.sistemadecontroledefuncionario.web.vagas.dtos.VagaFormulario;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class VagaMapperImpl implements VagaMapper {

    private final ModelMapper mapper;

    @Override
    public Vaga toVaga(VagaFormulario vagaFormulario) {
        
        return mapper.map(vagaFormulario, Vaga.class);
    }

    @Override
    public VagaDetalhes toVagaDetalhes(Vaga vaga) {
        return mapper.map(vaga, VagaDetalhes.class);
    }

}
