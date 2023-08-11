package com.consumidor.projetosite.dto;

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
public class StockDTO {
    private Long id;
    private ItemDTO item;
}
