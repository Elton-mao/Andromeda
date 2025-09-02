package com.sistemadecontroledefuncionario.core.usuario.services;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.sistemadecontroledefuncionario.core.usuario.enums.PerfilDeAcesso;
import com.sistemadecontroledefuncionario.core.usuario.enums.StatusDoUsuario;
import com.sistemadecontroledefuncionario.core.utils.DateTimeUtils;
import com.sistemadecontroledefuncionario.web.admin.dtos.AdminDashboard;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class AdminDashBoardServiceImpl implements AdminDashBoardService {

    private final AdminUsuarioService adminUsuarioService;

    @Override
    public AdminDashboard gerarAdminDashboard() {
        var usuarios = adminUsuarioService.findAll();
        Long perfisAtivos = usuarios.stream()
        .filter(t -> t.getStatusDoUsuario() == StatusDoUsuario.ATIVO)
        .count();
        return AdminDashboard.builder()
                .totalDeUsuarios(usuarios.size())
                .perfisAtivos(perfisAtivos.intValue())
                .errosDeLogin(4)
                .ultimoAcessoAdmin(DateTimeUtils.formataDataPadraoBrasileiro(LocalDateTime.now()))
                .usuarios(usuarios)
                .perfis(Arrays.asList(PerfilDeAcesso.values()))
                .build();

    }

}
