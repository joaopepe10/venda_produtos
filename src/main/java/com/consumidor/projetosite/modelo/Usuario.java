package com.consumidor.projetosite.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(nullable = false)
    private String nomeUsuario;

    @Column(nullable = false)
    private String senhaUsuario;

    @OneToOne
    @JoinColumn(name = "id_carrinho_FK", referencedColumnName = "id_carrinho")
    private Carrinho carrinho;

}
