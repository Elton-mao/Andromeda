package com.sistemadecontroledefuncionario.core.usuario.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.sistemadecontroledefuncionario.core.usuario.enums.PerfilDeAcesso;
import com.sistemadecontroledefuncionario.core.usuario.enums.StatusDoUsuario;
import com.sistemadecontroledefuncionario.core.usuario.mappers.UsuarioMapper;
import com.sistemadecontroledefuncionario.core.usuario.model.Usuario;
import com.sistemadecontroledefuncionario.core.usuario.repository.UsuarioRepository;
import com.sistemadecontroledefuncionario.web.usuario.dto.UsuarioDetalhes;
import com.sistemadecontroledefuncionario.web.usuario.dto.UsuarioFormulario;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminUsuarioServiceImpl implements AdminUsuarioService {

    private final UsuarioMapper usuarioMapper;

    private final UsuarioRepository usuarioRepository;

    /**s
     * Salva um novo usuário com base no {@link UsuarioForm} fornecido.
     * <p>
     * Este método mapeia o formulário para uma entidade {@link Usuario}, persiste
     * usando o repositório,
     * e então converte a entidade salva para um DTO {@link UsuarioDetails}.
     * </p>
     *
     * @param form o formulário contendo os dados do usuário a ser salvo
     * @return os detalhes do usuário salvo
     * @throws IllegalArgumentException se o formulário fornecido for nulo ou
     *                                  inválido
     */
    @Override
    public UsuarioDetalhes save(final UsuarioFormulario form) {
        return Optional.ofNullable(form)
                .map(usuarioMapper::toUsuario)
                .map(usuarioRepository::save)
                .map(usuarioMapper::toUsuarioDetalhes)
                .orElseThrow(() -> new IllegalArgumentException("Formulario Invalido"));
    }

    
    /**
     * Recupera um {@link UsuarioDetails} pelo seu identificador único.
     *
     * @param id o identificador único do usuário a ser recuperado
     * @return o {@link UsuarioDetails} correspondente ao id fornecido
     * @throws IllegalArgumentException se nenhum usuário com o id especificado
     *                                  existir
     */
    @Override
    public UsuarioDetalhes findById(String id) {
        return usuarioRepository.findById(id)
                .map(usuarioMapper::toUsuarioDetalhes)
                .orElseThrow(() -> new IllegalArgumentException("id informado não Existe"));
    }

    /**
     * Recupera todos os usuários do repositório e os mapeia para objetos
     * {@link UsuarioDetails}.
     *
     * @return uma lista de {@link UsuarioDetails} representando todos os usuários.
     */
    @Override
    public List<UsuarioDetalhes> findAll() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuarioMapper::toUsuarioDetalhes)
                .toList();
    }

    /**
     * Remove um usuário pelo seu identificador único.
     * 
     * Verifica se o usuário com o ID fornecido existe no repositório.
     * Caso não exista, lança uma IllegalArgumentException.
     * Se existir, remove o usuário correspondente.
     *
     * @param id o identificador único do usuário a ser removido
     * @throws IllegalArgumentException se o ID informado não existir no repositório
     */
    @Override
    public void removerPorId(String id) {
        if (!usuarioRepository.existsById(id)) {
            throw new IllegalArgumentException("Id Informado não existe");
        }
        usuarioRepository.deleteById(id);
    }

    /**
     * Atualiza os dados de um usuário existente com base no formulário fornecido.
     *
     * @param id          O identificador do usuário a ser atualizado.
     * @param usuarioForm O formulário contendo os novos dados do usuário.
     * @return Os detalhes do usuário atualizados.
     * @throws IllegalArgumentException Se o usuário com o ID fornecido não for
     *                                  encontrado.
     */
    @Override
    public UsuarioDetalhes atualizar(String id, UsuarioFormulario usuarioForm) {
        var usuario = usuarioRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        BeanUtils.copyProperties(usuarioForm, usuario, "id", "senha", "statusDoUsuario");
        usuario = usuarioRepository.save(usuario);
        return usuarioMapper.toUsuarioDetalhes(usuario);
    }

    /**
     * Recupera um {@link UsuarioDetails} pelo seu Perfil.
     *
     * @param perfilDeAcesso o enum perfil de Acesso de cada usuario
     * @return o {@link UsuarioDetails} correspondente ao id fornecido
     * @throws IllegalArgumentException se nenhum usuário com o id especificado
     *                                  existir
     */
    @Override
    public List<UsuarioDetalhes> buscarPorPerfilDeAcesso(PerfilDeAcesso perfilDeAcesso) {
        return usuarioRepository.findByPerfilDeAcesso(perfilDeAcesso).stream()
                .map(usuarioMapper::toUsuarioDetalhes)
                .toList();
    }

    @Override
    public void bloquearUsuario(String id, StatusDoUsuario novoEstatus) {
        var usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario não Encontrado"));
        if (usuario.getStatusDoUsuario() == novoEstatus) {
            throw new IllegalArgumentException("Usuário já está com status: " + novoEstatus);
        }
        usuario.setStatusDoUsuario(novoEstatus);
        usuarioRepository.save(usuario);
    }


    @Override
    public Usuario findEntityById(String id) {
        return usuarioRepository.findById(id)
        .orElseThrow(IllegalArgumentException::new);
    }

}
