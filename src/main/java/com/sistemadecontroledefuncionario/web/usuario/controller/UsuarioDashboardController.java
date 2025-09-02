package com.sistemadecontroledefuncionario.web.usuario.controller;

import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sistemadecontroledefuncionario.core.usuario.services.UsuarioDashBoardService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/dashboard")
public class UsuarioDashboardController {

    private final UsuarioDashBoardService dashBoard;

    @GetMapping("/gestor/{id}")
    public ModelAndView dashbooardDoGestor(@PathVariable String id) {
        var model = Map.of(
                "dashboard", dashBoard.gerarDashboardGestor(id));
        return new ModelAndView("usuario/dashboard-gestor", model);
    }

    @GetMapping("/rh/{id}")
    public ModelAndView painelDoRh(@PathVariable String id) {

        var model = Map.of(
                "dashboard", dashBoard.gerarPainelDoRhDashboard(id));
        return new ModelAndView("usuario/painel-rh", model);
    }

    @GetMapping("diretor/{id}")
    public ModelAndView painelDodiretor(@PathVariable String id) {
        var model = Map.of(
                "dashboard", dashBoard.gerarPainelDoDiretorDashboard(id));
        return new ModelAndView("usuario/painel-diretor", model);
    }
}
