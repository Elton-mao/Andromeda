package com.sistemadecontroledefuncionario.web.cargo.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sistemadecontroledefuncionario.core.cargo.service.CargoService;
import com.sistemadecontroledefuncionario.web.cargo.CargoFormulario;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
@RequestMapping("/cargos")
public class CargoController {

    private final CargoService cargoService; 

    @GetMapping("/criar")
    public ModelAndView criarCargo(){
        var model = Map.of(
            "cargoFormulario",new CargoFormulario()
        );
        return new ModelAndView("cargo/novo-cargo",model);
    }

    @PostMapping("/criar")
    public String criarCargo(@ModelAttribute CargoFormulario formulario ) {
        cargoService.criarCargo(formulario);
        return "redirect:/usuarios/dashboard";
    }
    
}
