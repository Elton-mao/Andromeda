package com.sistemadecontroledefuncionario.core.cargo.model;

import java.math.BigDecimal;
import java.util.List;

import com.sistemadecontroledefuncionario.core.vaga.model.Vaga;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Entity
@Builder
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Cargos")
public class Cargo {

    @Id
    @Column(name = "id", length = 36)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "titulo_do_cargo", nullable = false, length = 50)
    private String tituloDoCargo;

    @Column(name = "salario")
    private BigDecimal salario;
    
    @OneToMany(mappedBy = "cargo", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Vaga> vagas;

}
