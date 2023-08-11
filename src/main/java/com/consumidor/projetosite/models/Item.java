package com.consumidor.projetosite.models;

import com.consumidor.projetosite.dto.ItemDTO;
import com.consumidor.projetosite.enums.CategoryENUM;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_item", nullable = false)
    private String nome;

    @Column(name = "preco_item", nullable = false)
    private BigDecimal preco;

    @Column(nullable = false, name = "quantidade_item")
    private Long quantidade;

    @ManyToMany
    @JoinTable(
            name = "tbl_aux_item_stock",
            joinColumns = {@JoinColumn(name = "id_item", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "id_stock", referencedColumnName = "id")}
    )
    //@JsonIgnore QUANDO CHAMA O findAll DO ESTOQUE, LISTA OS ITENS QUE ESTAO DENTRO DO ESTOQUE
    private List<Stock> stocks;

    @ManyToOne
    @JoinColumn(name = "id_pedido_FK_item")
    @JsonIgnore
    private Order order;

    public Item(ItemDTO dto){
        this.nome = dto.getNome();
        this.preco = dto.getPreco();
        this.quantidade = dto.getQuantidade();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item item)) return false;
        return Objects.equals(getId(), item.getId()) && Objects.equals(getNome(), item.getNome()) && Objects.equals(getPreco(), item.getPreco()) && Objects.equals(getQuantidade(), item.getQuantidade()) && Objects.equals(getOrder(), item.getOrder());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
