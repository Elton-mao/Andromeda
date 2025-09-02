package com.sistemadecontroledefuncionario.web.usuario.dto;

import com.sistemadecontroledefuncionario.core.usuario.enums.PerfilDeAcesso;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioFormulario {

    private String login;

    private String nomeCompleto;

    private String email;

    private String senha;
    
    private String setorId;

    private PerfilDeAcesso perfilDeAcesso;


}
