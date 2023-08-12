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
      this.nome = item.getName();
      this.preco = item.getPrice();
   }
}
