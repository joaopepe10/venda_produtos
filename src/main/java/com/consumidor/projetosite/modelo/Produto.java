package com.consumidor.projetosite.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(nullable = false)
    private String nomeProduto;

    @Column(nullable = false)
    private Float precoProduto;

    @ManyToOne
    @JoinColumn(name = "id_carrinhp_FK", referencedColumnName = "id_carrinho")
    private Carrinho carrinho;

}
