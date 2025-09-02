package com.sistemadecontroledefuncionario.core.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sistemadecontroledefuncionario.core.usuario.enums.StatusDoUsuario;
import com.sistemadecontroledefuncionario.core.usuario.model.Usuario;
import com.sistemadecontroledefuncionario.core.utils.StringNormalizer;
import com.sistemadecontroledefuncionario.web.usuario.dto.UsuarioFormulario;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        var modelMapper = new ModelMapper();
        
        //Força A inicialização de Sempre Ativo no momento do Cadastro
        modelMapper.typeMap(UsuarioFormulario.class, Usuario.class)
                .addMappings(mapper -> {
                    mapper.map(src -> StatusDoUsuario.ATIVO, Usuario::setStatusDoUsuario);
                    
                    mapper.using(ctx -> StringNormalizer.toLowerCase((String) ctx.getSource()))
                    .map(UsuarioFormulario::getLogin, Usuario::setLogin);
                    
                    mapper.using(ctx -> StringNormalizer.toLowerCase((String) ctx.getSource()))
                    .map(UsuarioFormulario::getEmail, Usuario::setEmail);
                });
                
                

        return modelMapper;

    }

}
