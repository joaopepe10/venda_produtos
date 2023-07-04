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
    private String nome_produto;

    @Column(nullable = false)
    private Float preco_produto;

    //VARIOS PRODUTOS NO CARRINHO
    /*@ManyToOne
    @JoinColumn(name = "id_carrinho_FK", referencedColumnName = "id_carrinho", columnDefinition = "1")
    private Carrinho carrinho;*/

    //VARIOS PRODUTOS NO ESTOQUE
    /*@ManyToOne
    @JoinColumn(name = "id_estoque_FK", referencedColumnName = "id_estoque")
    private Estoque estoque;*/

}
