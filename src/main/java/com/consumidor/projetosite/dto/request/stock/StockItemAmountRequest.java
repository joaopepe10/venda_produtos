package com.consumidor.projetosite.dto.request.stock;

import com.consumidor.projetosite.dto.request.item.ItemAmountRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockItemAmountRequest {
    private Long id;
    private ItemAmountRequest item;
}
