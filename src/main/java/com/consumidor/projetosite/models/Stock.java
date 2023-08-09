package com.consumidor.projetosite.models;

import com.consumidor.projetosite.enums.CategoryENUM;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_stock")
public class Stock implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private CategoryENUM categoria;

    @OneToMany(mappedBy = "stock", cascade = CascadeType.ALL)
    private List<Item> produtos = new ArrayList<>();

    public Stock(Long id, CategoryENUM categoria){
        this.categoria = categoria;
    }

    public void saveItem(Item item){
        produtos.add(item);
    }

    public void saveItem(List<Item> items){
        produtos.addAll(items);
    }

    public void changeQuantity(Item item){
        for (Item i : this.produtos){
            if (i.equals(item)){
                i.setQuantidade(i.getQuantidade() + item.getQuantidade());
            }
        }
    }
}
