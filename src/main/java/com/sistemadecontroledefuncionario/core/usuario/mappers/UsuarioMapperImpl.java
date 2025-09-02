package com.sistemadecontroledefuncionario.core.usuario.mappers;

import org.springframework.stereotype.Component;

import com.sistemadecontroledefuncionario.core.setor.repository.SetorRepository;
import com.sistemadecontroledefuncionario.core.usuario.enums.StatusDoUsuario;
import com.sistemadecontroledefuncionario.core.usuario.model.Usuario;
import com.sistemadecontroledefuncionario.web.usuario.dto.UsuarioDetalhes;
import com.sistemadecontroledefuncionario.web.usuario.dto.UsuarioFormulario;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UsuarioMapperImpl implements UsuarioMapper {

    private final SetorRepository setorRepository; 

    @Override
    public Usuario toUsuario(UsuarioFormulario form) {
    	
    	var setor = setorRepository.findById(form.getSetorId()).get();
    	
        return Usuario.builder()
        		.login(form.getLogin())
        		.nomeCompleto(form.getNomeCompleto())
        		.email(form.getEmail())
        		.senha(form.getSenha())
        		.perfilDeAcesso(form.getPerfilDeAcesso())
        		.statusDoUsuario(StatusDoUsuario.ATIVO)
        		.setor(setor)
        		.build();
    }

    @Override
    public UsuarioDetalhes toUsuarioDetalhes(Usuario usuario) {
    	
        return UsuarioDetalhes.builder()
        		.id(usuario.getId())
        		.login(usuario.getLogin())
        		.nomeCompleto(usuario.getNomeCompleto())
        		.email(usuario.getEmail())
        		.perfilDeAcesso(usuario.getPerfilDeAcesso())
        		.statusDoUsuario(usuario.getStatusDoUsuario())
        		.setor(usuario.getSetor())
        		.build();

}

}