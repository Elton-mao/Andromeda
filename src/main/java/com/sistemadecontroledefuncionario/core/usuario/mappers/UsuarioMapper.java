package com.sistemadecontroledefuncionario.core.usuario.mappers;

import com.sistemadecontroledefuncionario.core.usuario.model.Usuario;
import com.sistemadecontroledefuncionario.web.usuario.dto.UsuarioDetalhes;
import com.sistemadecontroledefuncionario.web.usuario.dto.UsuarioFormulario;

/**
 * Mapper interface for converting between Usuario entities and their corresponding DTOs.
 * Provides methods to map from form data to entity and from entity to detailed DTO.
 */
public interface UsuarioMapper {
    Usuario toUsuario(UsuarioFormulario form);
    UsuarioDetalhes toUsuarioDetalhes(Usuario usuario); 
}
