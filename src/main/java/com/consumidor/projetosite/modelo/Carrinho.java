package com.consumidor.projetosite.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "tbl_carrinho")
public class Carrinho implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_carrinho_PK;

    private Integer quantidadeRequerida;

   @OneToMany(mappedBy = "carrinho") //nome do atributo criado na outra classe/tabela
   @Column(nullable = false)
   private List<Item> itens = new ArrayList<>();

    public Carrinho() {
    }

    public Carrinho(Integer quantidadeRequerida,List<Item> itens) {
        this.itens = itens;
        this.quantidadeRequerida = quantidadeRequerida;
    }

    public Carrinho(Item item, Integer quantidadeRequerida){
        this.itens.add(item);
        this.quantidadeRequerida = quantidadeRequerida;
    }

}