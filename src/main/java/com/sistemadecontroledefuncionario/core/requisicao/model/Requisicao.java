package com.sistemadecontroledefuncionario.core.requisicao.model;

import java.time.LocalDateTime;

import com.sistemadecontroledefuncionario.core.requisicao.enums.Prioridade;
import com.sistemadecontroledefuncionario.core.requisicao.enums.StatusDaRequisicao;
import com.sistemadecontroledefuncionario.core.requisicao.enums.TipoDeSolicitacao;
import com.sistemadecontroledefuncionario.core.usuario.model.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "Requisicao")
@Inheritance(strategy =  InheritanceType.JOINED)
public abstract class Requisicao {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", columnDefinition = "VARCHAR(36)")
    private String id;

    @Column(name = "data_criacao", nullable = false)
    private LocalDateTime dataDaCriacao;
    
    @Column(name="numero_requisicao",insertable =  false, updatable = false)
    private int numeroDaRequisicao;  // numero da requisição legivel gerado automaticamente de maneira incremental foi delegado ao banco de dados fazer essa geração de numero 

    @Enumerated(EnumType.STRING)
    @Column(name = "status_da_requisicao", length = 20, nullable = false)
    private StatusDaRequisicao statusDaRequisicao;

    @Enumerated(EnumType.STRING)
    @Column(name = "prioridade", length = 20, nullable = false)
    private Prioridade prioridade;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_de_solicitacao", length = 50, nullable = false)
    private TipoDeSolicitacao tipoDesolicitacao;

    @ManyToOne
    @JoinColumn(name = "solicitante_id", referencedColumnName = "id")
    private Usuario solicitante;

}
