package com.sistemadecontroledefuncionario.web.usuario.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sistemadecontroledefuncionario.core.requisicao.services.RequisicaoService;
import com.sistemadecontroledefuncionario.core.setor.service.SetorService;
import com.sistemadecontroledefuncionario.core.usuario.enums.PerfilDeAcesso;
import com.sistemadecontroledefuncionario.core.usuario.enums.StatusDoUsuario;
import com.sistemadecontroledefuncionario.core.usuario.services.AdminUsuarioService;
import com.sistemadecontroledefuncionario.web.usuario.dto.UsuarioFormulario;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/usuarios")
public class AdminUsuarioController {
   
    private final AdminUsuarioService adminUsuarioService;
    private final RequisicaoService requisicaoService;
    private final SetorService setorService;
 

    @GetMapping("/all")
    public ModelAndView buscaTodos() {
        var usuarios = adminUsuarioService.findAll();
        var model = Map.of("usuario", usuarios);
        return new ModelAndView("/usuario/listar-usuarios", model);
    }

    @GetMapping
    public ModelAndView cadastrarUsuario() {
    	var setores = setorService.buscarTodosSetores(); 
        var model = Map.of("usuarioFormulario", new UsuarioFormulario(),
                "perfisDeAcesso", PerfilDeAcesso.values(), 
                "setores",setores);
        return new ModelAndView("/usuario/criar-usuario", model);
    }

    @PostMapping
    public String cadastrarUsuario(@ModelAttribute UsuarioFormulario formulario) {
        adminUsuarioService.save(formulario);
        return "redirect:/admin";
    }

    @GetMapping("/{perfilDeAcesso}")
    public ModelAndView buscarPorPerfil(@PathVariable PerfilDeAcesso perfilDeAcesso) {
        var usuarios = adminUsuarioService.buscarPorPerfilDeAcesso(perfilDeAcesso);
        var model = Map.of("usuario", usuarios);
        return new ModelAndView("/usuario/listar-usuarios", model);
    }

    @GetMapping("/atualizar/{id}")
    public ModelAndView atualizar(@PathVariable String id) {
        var usuario = adminUsuarioService.findById(id);
        var model = Map.of("usuarioFormulario", usuario,
                "perfisDeAcesso", PerfilDeAcesso.values());
        return new ModelAndView("usuario/atualizar-usuario", model);
    }

    @PostMapping("/atualizar/{id}")
    public String atualizar(@PathVariable String id, @ModelAttribute UsuarioFormulario usuarioForm) {
        adminUsuarioService.atualizar(id, usuarioForm);
        return "redirect:/admin";

    }

    @GetMapping("/excluir/{id}")
    public String excluirUsuario(@PathVariable String id) {
        adminUsuarioService.removerPorId(id);
        return "redirect:/admin";
    }

    @GetMapping("/bloquear/{id}/{novoStatus}")
    public String desabilitarUsuario(@PathVariable String id, @PathVariable StatusDoUsuario novoStatus) {
        adminUsuarioService.bloquearUsuario(id, novoStatus);
        return "redirect:/admin";

    }

    @GetMapping("/{id}/requisicoes")
    public ModelAndView requisicoesPorId(@PathVariable String id) {
        var requisicoes = requisicaoService.listarRequisicoesPorFuncionarioId(id);
        var model = Map.of("requisicoes", requisicoes);
        return new ModelAndView("/usuario/minhas-requisicoes", model);
}

   

} 