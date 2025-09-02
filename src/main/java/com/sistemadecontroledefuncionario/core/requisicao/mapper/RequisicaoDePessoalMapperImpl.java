package com.sistemadecontroledefuncionario.core.requisicao.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.sistemadecontroledefuncionario.core.cargo.repository.CargoRepository;
import com.sistemadecontroledefuncionario.core.centroDeCusto.service.CentroDeCustoService;
import com.sistemadecontroledefuncionario.core.requisicao.model.RequisicaoDePessoal;
import com.sistemadecontroledefuncionario.core.usuario.services.AdminUsuarioService;
import com.sistemadecontroledefuncionario.core.vaga.mappers.VagaMapper;
import com.sistemadecontroledefuncionario.web.requisicao.dtos.RequisicaoDePessoalDetalhes;
import com.sistemadecontroledefuncionario.web.requisicao.dtos.RequisicaoDePessoalFormulario;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RequisicaoDePessoalMapperImpl implements RequisicaoDePessoalMapper {

    private final ModelMapper mapper;
    private final VagaMapper vagaMapper;
    private final CargoRepository cargoRepository;
    private final AdminUsuarioService usuarioService;
    private final CentroDeCustoService centroDeCustoService;
    // private final RequsicaoDeTiMapper requisicaoDeTiMapper;

    @Override
    public RequisicaoDePessoal toRequisicaoDePessoal(RequisicaoDePessoalFormulario formulario) {

        var usuario = usuarioService.findEntityById(formulario.getSolicitante());

        var cargo = cargoRepository.findById(formulario.getVaga().getCargoId()) // TODO : FAZER ESSE METODO NO SERVICE
                .orElseThrow(IllegalArgumentException::new);

        var centroDeCusto = centroDeCustoService.buscarPorIdEntidade(formulario.getCentroDeCustoId());

        var requisicao = RequisicaoDePessoal.builder()
                .dataLimiteDaContracao(formulario.getDataLimiteDaContracao())
                .quantidadeDeVagas(formulario.getQuantidadeDeVagas())
                .solicitante(usuario)
                .centroDeCusto(centroDeCusto)
                .tipoDesolicitacao(formulario.getTipoDeSolicitacao())
                .motivoDaRequisicao(formulario.getMotivoDaRequisicao())
                .prioridade(formulario.getPrioridade())
                // .requisicaoDeTi( 
                //         formulario.getRequisicaoDeTi() != null?
                //         requisicaoDeTiMapper.toRequisicaoDeTi(formulario.getRequisicaoDeTi()):
                //         null )
                        
                .build();
        
        var qtd = formulario.getQuantidadeDeVagas();
        var vagaBase = formulario.getVaga();

        for (int i = 0; i < qtd; i++) {
            var vagaEntity = vagaMapper.toVaga(vagaBase);
            // Precisamos limpar o ID para garantir que o Hibernate trate como nova entidade
            // Isso evita o erro de detached entity quando persistimos a requisição
            vagaEntity.setId(null);
            vagaEntity.setRequisicao(requisicao);
            vagaEntity.setCargo(cargo);
            requisicao.adicionarVaga(vagaEntity);
        }

        return requisicao;
    }

    @Override
    public RequisicaoDePessoalDetalhes toRequisicaoDePessoalDetalhes(RequisicaoDePessoal requisicaoDePessoal) {
        return mapper.map(requisicaoDePessoal, RequisicaoDePessoalDetalhes.class);
    }

}
