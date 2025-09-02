package com.sistemadecontroledefuncionario.core.recursosDeTi.model;

import com.sistemadecontroledefuncionario.core.recursosDeTi.enums.CategoriaRecursoTi;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

@Getter
@Setter
@Builder
@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name="recurso_de_ti")
public class RecursoDeTi {
   
   @Id
   @GeneratedValue(strategy = GenerationType.UUID)
   private String id;

   @Column(name = "titulo")
   private String titulo;

   @Column(name = "descricao")
   private String descricao; 

   @Column(name = "ativo")
   private Boolean ativo; 
   
   @Column(name = "categoria")
   @Enumerated(EnumType.STRING)
   private CategoriaRecursoTi categoriaRecursoTi; 

   
}
