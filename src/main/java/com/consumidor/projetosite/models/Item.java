package com.consumidor.projetosite.models;

import com.consumidor.projetosite.enums.CategoryENUM;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_items")
public class Item implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item_PK")
    private Long id;


    @Column(name = "nome_item", nullable = false)
    private String nome;

    @Column( name = "preco_item",nullable = false)
    private Float preco;

    @Column(nullable = false, name = "quantidade_item")
    private Long quantidade;

    @ManyToOne
    @JoinColumn(name = "id_estoque_FK_item")
    @JsonIgnore //QUANDO CHAMA O findAll DO ESTOQUE, LISTA OS ITENS QUE ESTAO DENTRO DO ESTOQUE
    private Stock stock;

    @ManyToOne
    @JoinColumn(name = "id_carrinho_FK_item")
    @JsonIgnore
    private Cart cart;

    public Item(Long id,String s, float v, long l, Stock stock) {
        this.id = id;
        this.nome = s;
        this.preco = v;
        this.quantidade = l;
        this.stock = stock;
    }

    public Item(String nome , float valor, long quantidade, CategoryENUM categoria) {
        this.nome = nome;
        this.preco = valor;
        this.quantidade = quantidade;
        this.stock.setCategoria(categoria);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item item)) return false;
        return Objects.equals(getId(), item.getId()) && Objects.equals(getNome(), item.getNome()) && Objects.equals(getPreco(), item.getPreco()) && Objects.equals(getQuantidade(), item.getQuantidade()) && Objects.equals(getStock(), item.getStock()) && Objects.equals(getCart(), item.getCart());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
