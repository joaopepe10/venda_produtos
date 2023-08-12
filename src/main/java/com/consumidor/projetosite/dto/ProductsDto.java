package com.consumidor.projetosite.dto;

import lombok.*;

/**
 *  produtos":
 *           {
 *               "produto":1,
 *               "quantidade":5
 *           }
/**/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductsDto {
    private Long produto;
    private Long quantidade;
}
