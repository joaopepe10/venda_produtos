package com.consumidor.projetosite.dto.request.stock;

import com.consumidor.projetosite.dto.request.item.ItemRequest;
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
public class StockRequestItem {
    private Long id;
    private ItemRequest item;
}
