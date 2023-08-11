package com.consumidor.projetosite.services;

import com.consumidor.projetosite.dto.ItemAmountDto;
import com.consumidor.projetosite.dto.StockDto;
import com.consumidor.projetosite.dto.StockItemAmountDto;
import com.consumidor.projetosite.models.Item;
import com.consumidor.projetosite.models.Stock;

import java.util.List;

public interface StockService {
    Stock save(Stock stock);
    Stock saveItem(StockDto dto);
    List<Stock> findAll();
    Item changeAmount(ItemAmountDto item, Long id);
    Stock saveItemWithRelation(StockItemAmountDto dto);
    List<Stock> saveAll(List<Stock> stocks);
}
