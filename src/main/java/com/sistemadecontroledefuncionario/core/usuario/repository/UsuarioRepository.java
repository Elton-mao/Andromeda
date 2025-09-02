package com.sistemadecontroledefuncionario.core.usuario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemadecontroledefuncionario.core.usuario.enums.PerfilDeAcesso;
import com.sistemadecontroledefuncionario.core.usuario.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,String>{
    List<Usuario> findByPerfilDeAcesso(PerfilDeAcesso perfilDeAcesso);

}
