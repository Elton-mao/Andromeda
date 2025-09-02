package com.sistemadecontroledefuncionario.web.admin.dtos;

import java.util.List;

import com.sistemadecontroledefuncionario.core.usuario.enums.PerfilDeAcesso;
import com.sistemadecontroledefuncionario.core.usuario.enums.StatusDoUsuario;
import com.sistemadecontroledefuncionario.web.usuario.dto.UsuarioDetalhes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AdminDashboard {
    private int totalDeUsuarios;
    private int perfisAtivos;
    private int errosDeLogin;
    private String ultimoAcessoAdmin;
    private List<UsuarioDetalhes> usuarios;
    private List<PerfilDeAcesso> perfis;
    private List<StatusDoUsuario> statusDoUsuarios;
    // private List<Logs> logs;

}
