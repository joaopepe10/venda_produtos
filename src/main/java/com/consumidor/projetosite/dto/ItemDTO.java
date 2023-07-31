package com.consumidor.projetosite.dto;

import com.consumidor.projetosite.enums.CategoryENUM;
import com.consumidor.projetosite.models.Cart;
import com.consumidor.projetosite.models.Stock;
import com.consumidor.projetosite.models.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemDTO {
    private Long id;
    private String nome;
    private Float preco;
    private Long quantidade;
    private Stock stock;
    private Cart cart;

    public ItemDTO(Item item){
        id = item.getId();
        nome = item.getNome();
        preco = item.getPreco();
        quantidade = item.getQuantidade();
        stock = item.getStock();
        cart = item.getCart();
    }
    public ItemDTO(Item item, CategoryENUM categoria){
        id = item.getId();
        nome = item.getNome();
        preco = item.getPreco();
        quantidade = item.getQuantidade();
        stock.setCategoria(categoria);
    }
}
