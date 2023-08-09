package com.consumidor.projetosite.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "tbl_cart")
public class Order implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_carrinho_PK;

    private Integer quantidade;

   @OneToMany(mappedBy = "cart") //nome do atributo criado na outra classe/tabela
   @Column(nullable = false)
   private List<Item> itens = new ArrayList<>();

    public Order() {
    }

    public Order(Integer quantidade, List<Item> itens) {
        this.itens = itens;
        this.quantidade = quantidade;
    }

    public Order(Item item, Integer quantidade){
        this.itens.add(item);
        this.quantidade = quantidade;
    }

}
