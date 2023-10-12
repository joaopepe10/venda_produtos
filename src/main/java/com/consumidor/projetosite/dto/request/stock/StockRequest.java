package com.consumidor.projetosite.dto.request.stock;

import com.consumidor.projetosite.enums.CategoryENUM;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockRequest {
    private CategoryENUM category;
}
