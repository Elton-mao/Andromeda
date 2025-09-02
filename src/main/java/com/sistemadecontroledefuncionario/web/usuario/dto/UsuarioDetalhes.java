package com.sistemadecontroledefuncionario.web.usuario.dto;

import com.sistemadecontroledefuncionario.core.setor.model.Setor;
import com.sistemadecontroledefuncionario.core.usuario.enums.PerfilDeAcesso;
import com.sistemadecontroledefuncionario.core.usuario.enums.StatusDoUsuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class UsuarioDetalhes {

    private String id;

    private String login;

    private String nomeCompleto;

    private String email;

    private PerfilDeAcesso perfilDeAcesso;

    private StatusDoUsuario statusDoUsuario;
    
    private Setor setor; 

}
