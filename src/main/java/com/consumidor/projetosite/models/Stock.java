package com.consumidor.projetosite.models;

import com.consumidor.projetosite.dto.ItemAmountDto;
import com.consumidor.projetosite.dto.StockDto;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private CategoryENUM categoria;

    @ManyToMany(mappedBy = "stocks")
    private List<Item> produtos = new ArrayList<>();

    public Stock(Long id, CategoryENUM categoria){
        this.categoria = categoria;
    }
    public Stock(StockDto dto){
        Item item = new Item(dto.getItem());
        this.id = dto.getId();
        this.produtos.add(item);
    }

    public void saveItem(Item item){
        produtos.add(item);
    }

    public void saveItem(List<Item> items){
        produtos.addAll(items);
    }

    public void changeAmount(ItemAmountDto item){
        for (Item i : this.produtos){
            if (i.getId().equals(item.getId())){
                i.setQuantidade(i.getQuantidade() + item.getQuantidade());
            }
        }
    }

    public Boolean cointainsItem(Item item){
        return produtos.contains(item);
    }
}
