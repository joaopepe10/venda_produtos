package com.consumidor.projetosite.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Item {
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
}
