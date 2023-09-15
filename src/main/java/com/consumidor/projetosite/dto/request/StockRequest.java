package com.consumidor.projetosite.dto.request;

import com.consumidor.projetosite.dto.request.ItemRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * {
 *   "id":1,
 *   "item":{
 *       "nome":"Iphone X",
 *       "preco":1300,
 *       "quantidade":12
 *   }
 * }
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockRequest {
    private Long id;
    private ItemRequest item;
}
