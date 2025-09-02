package com.sistemadecontroledefuncionario.web.requisicao.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/requisicoes")
public class RequisicaoController {
    // TODO implementar
    @GetMapping
    public String listarTodasRequicoes(@RequestParam String param) {
        return new String();
    }
    
}
