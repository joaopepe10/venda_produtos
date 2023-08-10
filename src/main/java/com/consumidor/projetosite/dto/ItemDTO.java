package com.consumidor.projetosite.dto;

import com.consumidor.projetosite.models.Item;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO {
   private String nome;
   private BigDecimal preco;
   private Long quantidade;

   public ItemDTO(Item item){
      this.nome = item.getNome();
      this.preco = item.getPreco();
      this.quantidade = item.getQuantidade();
   }
}
