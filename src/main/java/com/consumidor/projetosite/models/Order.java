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
@Table(name = "tbl_order")
public class Order implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer amount;

   @OneToMany(mappedBy = "order") //nome do atributo criado na outra classe/tabela
   @Column(nullable = false)
   private List<Item> itens = new ArrayList<>();

    public Order() {
    }

    public Order(Integer amount, List<Item> itens) {
        this.itens = itens;
        this.amount = amount;
    }

    public Order(Item item, Integer amount){
        this.itens.add(item);
        this.amount = amount;
    }

}
