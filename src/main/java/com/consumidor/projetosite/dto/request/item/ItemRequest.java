package com.consumidor.projetosite.dto.request.item;

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
   private String name;

   @NotNull(message = "Campo preco obrigatorio")
   private BigDecimal price ;

   public ItemRequest(Item item){
      this.name = item.getName();
      this.price = item.getPrice();
   }
}
