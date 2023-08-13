package com.consumidor.projetosite.dto.request;

import java.math.BigDecimal;

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

public class OrderRequest {

    private Long cliente;
    private BigDecimal total;
}
