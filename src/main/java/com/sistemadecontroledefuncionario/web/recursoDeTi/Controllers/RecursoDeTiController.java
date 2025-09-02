package com.sistemadecontroledefuncionario.web.recursoDeTi.Controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sistemadecontroledefuncionario.core.recursosDeTi.enums.CategoriaRecursoTi;
import com.sistemadecontroledefuncionario.core.recursosDeTi.service.RecursoDeTiService;
import com.sistemadecontroledefuncionario.web.recursoDeTi.dtos.RecursoDeTiFormulario;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/recurso-de-ti")
public class RecursoDeTiController {

    private final RecursoDeTiService recursoDeTiService; 

    @GetMapping
    public ModelAndView listar() {
        var recursos = recursoDeTiService.listarTodos();
        return new ModelAndView("recursoDeTi/listar", "recursos", recursos);
    }

    @GetMapping("/criar")
    public ModelAndView criar() {
        var model = Map.of( "categoria",CategoriaRecursoTi.values(),
        "formulario", new RecursoDeTiFormulario()
        );
        return new ModelAndView("recursoDeTi/criar-recurso", model);
    }

    
    @PostMapping("/criar")
    public String criar(@ModelAttribute RecursoDeTiFormulario formulario) {
        recursoDeTiService.criar(formulario);
        return "redirect:/recurso-de-ti";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable String id){
        recursoDeTiService.deletar(id);
        return "redirect:/recurso-de-ti";
    }
    
    @GetMapping("/atualizar/{id}")
    public ModelAndView atualizar(@PathVariable String id) {
        var recurso = recursoDeTiService.buscarPorId(id);
        var model = Map.of(
                "categoria", CategoriaRecursoTi.values(),
                "formulario", recurso
        );
        return new ModelAndView("recursoDeTi/atualizar-recurso", model);
    }

    @PostMapping("/atualizar/{id}")
    public String atualizar(@PathVariable String id, @ModelAttribute RecursoDeTiFormulario formulario) {
        recursoDeTiService.atualizar(id, formulario);
        return "redirect:/recurso-de-ti";
    }

}
