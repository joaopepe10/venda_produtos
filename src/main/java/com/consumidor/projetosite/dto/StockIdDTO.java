package com.consumidor.projetosite.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockIdDTO {
    private Long id;
    private ItemIdDTO item;
}
