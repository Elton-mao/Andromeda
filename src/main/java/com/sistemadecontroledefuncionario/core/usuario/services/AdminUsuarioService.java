package com.sistemadecontroledefuncionario.core.usuario.services;

import java.util.List;

import com.sistemadecontroledefuncionario.core.usuario.enums.PerfilDeAcesso;
import com.sistemadecontroledefuncionario.core.usuario.enums.StatusDoUsuario;
import com.sistemadecontroledefuncionario.core.usuario.model.Usuario;
import com.sistemadecontroledefuncionario.web.usuario.dto.UsuarioDetalhes;
import com.sistemadecontroledefuncionario.web.usuario.dto.UsuarioFormulario;

public interface AdminUsuarioService {
    UsuarioDetalhes save(UsuarioFormulario formulario);

    /**
     * Busca usuário pelo seu ID.
     *
     * @param id o identificador do usuario para busca
     */
    UsuarioDetalhes findById(String id);

    Usuario findEntityById(String id);

    /**
     * returna lista de todos os usuarios no banco de dados
     * 
     * @return List de usuarios convertidos em DTO
     */
    List<UsuarioDetalhes> findAll();

    /**
     * Remove um usuário pelo seu ID.
     *
     * @param id o identificador do usuário a ser removido
     */
    void removerPorId(String id);

    /**
     * Atualiza as informações de um usuário com base nos dados fornecidos no
     * {@link UsuarioForm}.
     *
     * @param usuarioForm objeto contendo os dados atualizados do usuário
     */
    UsuarioDetalhes atualizar(String id, UsuarioFormulario usuarioForm);

    List<UsuarioDetalhes> buscarPorPerfilDeAcesso(PerfilDeAcesso perfilDeAcesso);

    void bloquearUsuario(String id, StatusDoUsuario novoEstatus);

}
