package com.consumidor.projetosite.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * {   "id": 1,
 *     "produtos":
 *     [
 *         {
 *     "nome": "Iphone 12",
 *     "preco": 2900.50,
 *     "quantidade": 1
 *      }
 *     ]
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockDTO {
    private Long id;
    private ItemDTO item;
}
