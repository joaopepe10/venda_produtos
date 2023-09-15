package com.consumidor.projetosite.services;

import com.consumidor.projetosite.dto.request.ItemAmountRequest;
import com.consumidor.projetosite.dto.request.StockRequest;
import com.consumidor.projetosite.dto.request.StockItemAmountRequest;
import com.consumidor.projetosite.models.Item;
import com.consumidor.projetosite.models.Stock;

import java.util.List;

public interface StockService {
    Stock save(Stock stock);
    Stock saveItem(StockRequest dto);
    List<Stock> findAll();
    Item changeAmount(ItemAmountRequest item, Long id);
    Stock saveItemWithRelation(StockItemAmountRequest dto);
    List<Stock> saveAll(List<Stock> stocks);
}
