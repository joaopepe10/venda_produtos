package com.consumidor.projetosite.dto;

import com.consumidor.projetosite.models.Item;

import java.util.List;

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
public class StockDTO {
    private Long id;
    private List<Item> items;

}
