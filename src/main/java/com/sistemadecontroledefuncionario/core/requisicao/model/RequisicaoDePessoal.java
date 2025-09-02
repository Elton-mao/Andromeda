package com.sistemadecontroledefuncionario.core.requisicao.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.sistemadecontroledefuncionario.core.centroDeCusto.model.CentroDeCusto;
import com.sistemadecontroledefuncionario.core.requisicao.enums.MotivoDaRequisicao;
import com.sistemadecontroledefuncionario.core.vaga.model.Vaga;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "Requisicao_de_pessoal")
public class RequisicaoDePessoal extends Requisicao {

    @Column(name = "data_limite_contratacao", nullable = false)
    private LocalDate dataLimiteDaContracao;

    @Column(name = "quantidade_vagas", nullable = false)
    private int quantidadeDeVagas;

    @Enumerated(EnumType.STRING)
    @Column(name = "motivo_da_requisicao")
    private MotivoDaRequisicao motivoDaRequisicao;  

    @Column(name = "data_aprovacao")
    private LocalDateTime dataDaAprovacao;
    
    @ManyToOne
    @JoinColumn(name = "centro_de_custo_id", referencedColumnName = "id")
    private CentroDeCusto centroDeCusto;

    @OneToMany(mappedBy = "requisicao", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Vaga> vagas;

    @OneToOne(cascade = CascadeType.ALL,optional = true, orphanRemoval = true)
    @JoinColumn(name = "requisicao_ti_id")
    private RequisicaoDeTi requisicaoDeTi;

    /**
     * Adiciona uma vaga à requisição de pessoal.
     *
     * @param vaga A vaga a ser adicionada.
     */
    public void adicionarVaga(Vaga vaga) {
        if (this.vagas == null) {
            this.vagas = new ArrayList<>();
        }
        this.vagas.add(vaga);
        vaga.setRequisicao(this); // Garante a associação bidirecional
    }

}
