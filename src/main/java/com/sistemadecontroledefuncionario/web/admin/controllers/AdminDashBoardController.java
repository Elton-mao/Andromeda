package com.sistemadecontroledefuncionario.web.admin.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sistemadecontroledefuncionario.core.usuario.services.AdminDashBoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminDashBoardController {
    private final AdminDashBoardService adminDashBoardService;
    @GetMapping
    public ModelAndView adminDashBoard() {
        var adminDashBoard = adminDashBoardService.gerarAdminDashboard();
        var model = Map.of("adminDashboard", adminDashBoard);
        return new ModelAndView("/admin/administracao",model);
    }

    @GetMapping("/config")
    public ModelAndView configuracoes(){
        return new ModelAndView("/admin/configuracoes"); 
    }
}
