package com.sistemadecontroledefuncionario.core.centroDeCusto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Builder
@ToString
@Table(name = "Centro_de_custo")
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class CentroDeCusto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;
    
    @Column(name = "codigo")
    private String codigo;
    
    @Column(name = "nome")
    private String nome;

    @Column(name = "Descricao")
    private String descricao;
}
