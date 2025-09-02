package com.sistemadecontroledefuncionario.core.usuario.services;

import com.sistemadecontroledefuncionario.web.admin.dtos.AdminDashboard;

/**
 * Interface de serviço para geração do dashboard do administrador.
 * Fornece métodos para obter dados do dashboard para fins administrativos.
 */
public interface AdminDashBoardService {
    AdminDashboard gerarAdminDashboard();
}
