package com.consumidor.projetosite.services;

import com.consumidor.projetosite.dto.request.item.ItemAmountRequest;
import com.consumidor.projetosite.dto.request.stock.StockRequest;
import com.consumidor.projetosite.dto.request.stock.StockRequestItem;
import com.consumidor.projetosite.dto.request.stock.StockItemAmountRequest;
import com.consumidor.projetosite.models.Item;
import com.consumidor.projetosite.models.Stock;

import java.util.List;

public interface StockService {
    Stock save(Stock stock);
    Stock saveItem(StockRequestItem dto);
    List<Stock> findAll();
    Item changeAmount(ItemAmountRequest item, Long id);
    Stock saveItemWithRelation(StockItemAmountRequest dto);
    List<Stock> saveAll(List<StockRequest> stocks);
}
