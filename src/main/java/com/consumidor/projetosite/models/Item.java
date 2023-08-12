package com.consumidor.projetosite.models;

import com.consumidor.projetosite.dto.ItemDto;
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

    @Column(nullable = false)
    private String name;

    @Column(name = "unity_price", nullable = false)
    private BigDecimal price;

    @Column(columnDefinition = "INT DEFAULT 0")
    private Long amount;



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

    public Item(ItemDto dto){
        this.name = dto.getNome();
        this.price = dto.getPreco();
        this.amount = 0L;
    }
    public Item(String name, BigDecimal price){
        this.name = name;
        this.price = price;
        this.amount = 0L;
    }

    public BigDecimal sumTotal(){
        return new BigDecimal(String.valueOf(getPrice().multiply(BigDecimal.valueOf(getAmount()))));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item item)) return false;
        return Objects.equals(getId(), item.getId()) && Objects.equals(getName(), item.getName()) && Objects.equals(getPrice(), item.getPrice()) && Objects.equals(getAmount(), item.getAmount()) && Objects.equals(getOrder(), item.getOrder());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

}
