package com.consumidor.projetosite.dto;

import com.consumidor.projetosite.models.Item;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDto {
   private String nome;
   private BigDecimal preco;


   public ItemDto(Item item){
      this.nome = item.getNome();
      this.preco = item.getPreco();
   }
}
