package com.consumidor.projetosite.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Item implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item_PK")
    private Long id;

    @Column(name = "codigo_produto", nullable = false)
    private String codigo;

    @Column(name = "nome_item", nullable = false)
    private String nome;

    @Column( name = "preco_item",nullable = false)
    private Float preco;

    @Column(nullable = false, name = "quantidade_item")
    private Long quantidade;

    @ManyToOne
    @JoinColumn(name = "id_estoque_FK_item")
    @JsonIgnore //QUANDO CHAMA O findAll DO ESTOQUE, LISTA OS ITENS QUE ESTAO DENTRO DO ESTOQUE
    private Estoque estoque;

    @ManyToOne
    @JoinColumn(name = "id_carrinho_FK_item")
    @JsonIgnore
    private Carrinho carrinho;

    public Item() {
    }

    public Item(Long id, String nome, Float preco, Long qtd,Estoque e) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = qtd;
        this.estoque = e;
    }
    public Item(Long id, String nome, Float preco, Long qtd,Estoque e, Carrinho c) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = qtd;
        this.estoque = e;
        this.carrinho = c;
    }

    public Item(Long id, String codigo, String nome, Float preco, Long quantidade, Estoque estoque, Carrinho carrinho) {
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.estoque = estoque;
        this.carrinho = carrinho;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item item)) return false;
        return Objects.equals(getId(), item.getId()) && Objects.equals(getCodigo(), item.getCodigo()) && Objects.equals(getNome(), item.getNome()) && Objects.equals(getPreco(), item.getPreco()) && Objects.equals(getQuantidade(), item.getQuantidade()) && Objects.equals(getEstoque(), item.getEstoque()) && Objects.equals(getCarrinho(), item.getCarrinho());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCodigo());
    }
}
