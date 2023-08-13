package com.consumidor.projetosite.dto.request;

import com.consumidor.projetosite.models.Item;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemRequest {
   @NotEmpty(message = "Campo nome obrigatorio")
   private String nome;

   @NotNull(message = "Campo preco obrigatorio")
   private BigDecimal preco;


   public ItemRequest(Item item){
      this.nome = item.getName();
      this.preco = item.getPrice();
   }
}
