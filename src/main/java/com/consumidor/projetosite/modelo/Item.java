package com.consumidor.projetosite.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class Item implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_item;

    @Column(nullable = false)
    private String nome_item;

    @Column(nullable = false)
    private Float preco_item;

    @ManyToOne
    @JoinColumn(name = "estoque_id")
    private Estoque estoque;

    public Item() {
    }

    public Item(Long id_item, String nome_item, Float preco_item, Estoque estoque) {
        this.id_item = id_item;
        this.nome_item = nome_item;
        this.preco_item = preco_item;
        this.estoque = estoque;
    }

    public Item(Long id_item, String nome_item, Float preco_item) {
        this.id_item = id_item;
        this.nome_item = nome_item;
        this.preco_item = preco_item;
    }
}
