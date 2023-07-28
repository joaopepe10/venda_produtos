package com.consumidor.projetosite.dto;

import com.consumidor.projetosite.modelo.Carrinho;
import com.consumidor.projetosite.modelo.Estoque;
import com.consumidor.projetosite.modelo.Item;
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
    private Estoque estoque;
    private Carrinho carrinho;

    public ItemDTO(Item item){
        id = item.getId();
        nome = item.getNome();
        preco = item.getPreco();
        quantidade = item.getQuantidade();
        estoque = item.getEstoque();
        carrinho = item.getCarrinho();
    }
    public ItemDTO(Item item, String categoria){
        id = item.getId();
        nome = item.getNome();
        preco = item.getPreco();
        quantidade = item.getQuantidade();
        estoque.setCategoria(categoria);
    }
}
