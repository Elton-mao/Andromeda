package com.sistemadecontroledefuncionario.core.requisicao.model;

import java.time.LocalDateTime;
import java.util.List;

import com.sistemadecontroledefuncionario.core.recursosDeTi.model.RecursoDeTi;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
@Table(name="Requisicao_de_recurso_ti")
@EqualsAndHashCode(callSuper = false)
public class RequisicaoDeTi extends Requisicao{

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable( name = " Requisicao_ti_recursos",
        joinColumns = @JoinColumn(name = "requisicao_id"),  // FK para esta entidade
        inverseJoinColumns = @JoinColumn(name = "recurso_id") // FK para RecursoDeTi
    )
    private List<RecursoDeTi> recursos;
    
    @Column(name = "data_aprovacao")
    private LocalDateTime dataDaAprovacao;

    @OneToOne(mappedBy ="requisicaoDeTi")
    private RequisicaoDePessoal requisicaoDePessoal; 

    
}
