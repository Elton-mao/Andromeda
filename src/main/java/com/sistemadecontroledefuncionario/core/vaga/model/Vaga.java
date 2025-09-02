package com.sistemadecontroledefuncionario.core.vaga.model;

import com.sistemadecontroledefuncionario.core.cargo.model.Cargo;
import com.sistemadecontroledefuncionario.core.requisicao.model.RequisicaoDePessoal;
import com.sistemadecontroledefuncionario.core.vaga.enums.Cnh;
import com.sistemadecontroledefuncionario.core.vaga.enums.Escolaridade;
import com.sistemadecontroledefuncionario.core.vaga.enums.Isalubridade;
import com.sistemadecontroledefuncionario.core.vaga.enums.PosRequerida;
import com.sistemadecontroledefuncionario.core.vaga.enums.StatusVaga;
import com.sistemadecontroledefuncionario.core.vaga.enums.TipoDeContrato;
import com.sistemadecontroledefuncionario.core.vaga.enums.TurnoDeTrabalho;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@Entity
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Table(name = "vagas")
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false, columnDefinition = "VARCHAR(36)")
    private String id;

    @Column(name = "competencias_tecnicas",length = 255)
    private String competenciasTecnicas; 

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_contrato", nullable = false, length = 20)
    private TipoDeContrato tipoDeContrato;

    @Enumerated(EnumType.STRING)
    @Column(name = "turno_trabalho", nullable = false, length = 20)
    private TurnoDeTrabalho turnoDeTrabalho;

    @Enumerated(EnumType.STRING)
    @Column(name = "escolaridade", nullable = false, length = 20)
    private Escolaridade escolaridade;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private StatusVaga status;

    @Enumerated(EnumType.STRING)
    @Column(name = "isalubridade", nullable = false)
    private Isalubridade isalubridade;  

    @Enumerated(EnumType.STRING)
    @Column(name = "cnh_requerida", nullable = false)
    private Cnh cnhRequerida;

    
    @Enumerated(EnumType.STRING)
    @Column(name = "pos_requerida", nullable = false)
    private PosRequerida posRequerida; 
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "requisicao_id", nullable = false)
    private RequisicaoDePessoal requisicao;

    @ManyToOne
    @JoinColumn(name = "cargo_id", referencedColumnName = "id")
    private Cargo cargo;

}
