package com.consumidor.projetosite.dto;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * {
 *     "cliente": 1,
 *     "total": 100,
 *     "produtos": [
 *         {
 *             "produto":1,
 *             "quantidade":5
 *         }
 *     ]
 *
 * } *
*/

public class OrderDTO {

    private Long cliente;
    private BigDecimal total;
    private List<ProductsDTO> produtos;
}
