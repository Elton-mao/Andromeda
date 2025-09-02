package com.sistemadecontroledefuncionario.web.requisicao.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sistemadecontroledefuncionario.core.cargo.service.CargoService;
import com.sistemadecontroledefuncionario.core.centroDeCusto.service.CentroDeCustoService;
import com.sistemadecontroledefuncionario.core.recursosDeTi.service.RecursoDeTiService;
import com.sistemadecontroledefuncionario.core.requisicao.enums.MotivoDaRequisicao;
import com.sistemadecontroledefuncionario.core.requisicao.enums.Prioridade;
import com.sistemadecontroledefuncionario.core.requisicao.services.RequisicaoDePessoalService;
import com.sistemadecontroledefuncionario.core.usuario.services.AdminUsuarioService;
import com.sistemadecontroledefuncionario.core.vaga.enums.Cnh;
import com.sistemadecontroledefuncionario.core.vaga.enums.Escolaridade;
import com.sistemadecontroledefuncionario.core.vaga.enums.Isalubridade;
import com.sistemadecontroledefuncionario.core.vaga.enums.PosRequerida;
import com.sistemadecontroledefuncionario.core.vaga.enums.TipoDeContrato;
import com.sistemadecontroledefuncionario.core.vaga.enums.TurnoDeTrabalho;
import com.sistemadecontroledefuncionario.web.requisicao.dtos.RequisicaoDePessoalFormulario;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/requisicao")
public class RequisicaoDeFuncionarioController {

    private final AdminUsuarioService AdminUsuarioService;
    private final RequisicaoDePessoalService requisicaoDePessoalService;
    private final CargoService cargoService;
    private final CentroDeCustoService centroDeCustoService;
    private final RecursoDeTiService recursoDeTiService; 

    @GetMapping("/criar")
    public ModelAndView criarSolicitacao() {
        var requisicaoDepessoal = new RequisicaoDePessoalFormulario();

        var requisitantes = AdminUsuarioService.findAll();

        var cargos = cargoService.buscarTodosOsCargos();

        var centroDeCusto = centroDeCustoService.buscarTodos();

        var recursosdeTi = recursoDeTiService.listarTodos();

        var model = Map.ofEntries(
                Map.entry("requisicaoDepessoal", requisicaoDepessoal),
                Map.entry("requisitantes", requisitantes),
                Map.entry("turnos", TurnoDeTrabalho.values()),
                Map.entry("escolaridade", Escolaridade.values()),
                Map.entry("contrato", TipoDeContrato.values()),
                Map.entry("prioridade", Prioridade.values()),
                Map.entry("motivoDaRequisicao", MotivoDaRequisicao.values()),
                Map.entry("cargos", cargos),
                Map.entry("centroDeCusto", centroDeCusto),
                Map.entry("isalubridade", Isalubridade.values()),
                Map.entry("recursos",recursosdeTi),
                Map.entry("cnhRequerida", Cnh.values()),
                Map.entry("posRequerida", PosRequerida.values()));

        return new ModelAndView("solicitacao/nova-solicitacao", model);
    }

    @PostMapping("/criar")
    public String criarSolicitacao(@ModelAttribute RequisicaoDePessoalFormulario formulario) {
        requisicaoDePessoalService.criarRequisicaoDePessoal(formulario);
        System.out.println(formulario.getCentroDeCustoId());
        return "redirect:/admin";
    }

}