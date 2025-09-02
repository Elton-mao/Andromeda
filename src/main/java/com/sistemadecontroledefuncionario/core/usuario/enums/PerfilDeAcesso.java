/**
 * Enumeração que representa os diferentes perfis de acesso de usuários no sistema.
 * Cada perfil possui uma descrição associada.
 *
 * <ul>
 *   <li>GESTOR: Gestor</li>
 *   <li>ADMINISTRADOR: Administrador</li>
 *   <li>RH: Recursos Humanos</li>
 *   <li>DIRETOR: Diretor</li>
 * </ul>
 *
 * @author elton
 */
package com.sistemadecontroledefuncionario.core.usuario.enums;

public enum PerfilDeAcesso {
    GESTOR("Gestor"),
    ADMINISTRADOR("Administrador"),
    RH("Recursos Humanos"),
    DIRETOR("Diretor");

    private final String valor;

    PerfilDeAcesso(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
