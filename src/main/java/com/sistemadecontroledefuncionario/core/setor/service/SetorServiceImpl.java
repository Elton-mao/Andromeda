package com.sistemadecontroledefuncionario.core.setor.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistemadecontroledefuncionario.core.setor.mapper.SetorMapper;
import com.sistemadecontroledefuncionario.core.setor.repository.SetorRepository;
import com.sistemadecontroledefuncionario.web.setor.dtos.SetorDetalhes;
import com.sistemadecontroledefuncionario.web.setor.dtos.SetorFormulario;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SetorServiceImpl implements SetorService {
    private final SetorMapper mapper;
    private final SetorRepository setorRepository; 
    @Override
    public void Cadastrar(SetorFormulario formulario) {
        var novoSetor = mapper.toSetor(formulario);
        setorRepository.save(novoSetor);
    }

    @Override
    public SetorDetalhes buscarPorId(String id){
    		return setorRepository.findById(id)
    				.map(mapper::toDetalhes)
    				.orElseThrow(IllegalArgumentException::new);
    		
    }

	@Override
	public List<SetorDetalhes> buscarTodosSetores() {
		return setorRepository.findAll()
				.stream()
				.map(mapper::toDetalhes)
				.toList(); 
	}
    
    
}
