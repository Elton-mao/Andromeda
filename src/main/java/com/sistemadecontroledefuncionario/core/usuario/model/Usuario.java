package com.sistemadecontroledefuncionario.core.usuario.model;

import java.util.List;

import com.sistemadecontroledefuncionario.core.requisicao.model.Requisicao;
import com.sistemadecontroledefuncionario.core.setor.model.Setor;
import com.sistemadecontroledefuncionario.core.usuario.enums.PerfilDeAcesso;
import com.sistemadecontroledefuncionario.core.usuario.enums.StatusDoUsuario;

import jakarta.persistence.CascadeType;
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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Usuarios")
public class Usuario {

    @Id
    @Column(name = "id", columnDefinition = "VARCHAR(36)")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "login", nullable = false, length = 50, unique = true)
    private String login;

    @Column(name = "nome_completo", nullable = false, length = 100)
    private String nomeCompleto;

    @Column(name = "email", nullable = false, length = 150, unique = true)
    private String email;

    @Column(name = "senha", nullable = false, length = 50)
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(name = "perfil_de_acesso", nullable = false, length = 50)
    private PerfilDeAcesso perfilDeAcesso;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_do_usuario", nullable = false, length = 50)
    private StatusDoUsuario statusDoUsuario;

    @OneToMany(mappedBy = "solicitante", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Requisicao> requisicoes;
    
    @ManyToOne
    @JoinColumn(name="setor_id")
    private Setor setor; 
   

}
