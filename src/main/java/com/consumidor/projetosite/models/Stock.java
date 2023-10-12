package com.consumidor.projetosite.models;

import com.consumidor.projetosite.dto.request.item.ItemAmountRequest;
import com.consumidor.projetosite.dto.request.stock.StockRequest;
import com.consumidor.projetosite.dto.request.stock.StockRequestItem;
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

    @Column(nullable = false, unique = true)
    private CategoryENUM category;

    @ManyToMany(mappedBy = "stocks")
    private List<Item> products = new ArrayList<>();

    public Stock(CategoryENUM category){
        this.category = category;
    }
    public Stock(StockRequestItem dto){
        Item item = new Item(dto.getItem());
        this.id = dto.getId();
        this.products.add(item);
    }
    public Stock(StockRequest dto){
        this.category = dto.getCategory();
    }

    public void saveItem(Item item){
        products.add(item);
    }

    public void saveItem(List<Item> items){
        products.addAll(items);
    }

    public void changeAmount(ItemAmountRequest item){
        for (Item i : this.products){
            if (i.getId().equals(item.getId())){
                i.setAmount(i.getAmount() + item.getQuantidade());
            }
        }
    }
    public List<Stock> castingDtoAll(List<StockRequest> requests){
        List<Stock> stocks = new ArrayList<>();
        requests.forEach(r -> stocks.add(new Stock(r)));
        return stocks;
    }

    public Boolean cointainsItem(Item item){
        return products.contains(item);
    }
}
