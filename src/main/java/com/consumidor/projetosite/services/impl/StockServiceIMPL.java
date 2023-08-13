package com.consumidor.projetosite.services.impl;

import com.consumidor.projetosite.dto.request.ItemAmountRequest;
import com.consumidor.projetosite.dto.request.StockItemAmountRequest;
import com.consumidor.projetosite.exception.BusnissesRulesException;
import com.consumidor.projetosite.models.Item;
import com.consumidor.projetosite.models.Stock;
import com.consumidor.projetosite.repositories.ItemRepository;
import com.consumidor.projetosite.repositories.StockRepository;
import com.consumidor.projetosite.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StockServiceIMPL implements StockService {
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private ItemRepository itemRepository;

    public Stock save(Stock stock){
        return stockRepository.save(stock);
    }

    @Transactional
    public Stock saveItem(StockDto dto){
       Item item = new Item(dto.getItem());
        Stock stock = stockRepository
                .findById(dto.getId())
                .orElseThrow(()-> new BusnissesRulesException("Codigo de estoque invalido!"));
        itemRepository.save(item);
        stock.getProducts().add(item);
    return stockRepository.save(stock);
    }

    @Transactional
    public Stock saveItemWithRelation(StockItemAmountRequest dto) {
        Stock stock = stockRepository
                .findById(dto.getId())
                .orElseThrow(() -> new BusnissesRulesException("Codigo do estoque invalido!"));
        Item item = itemRepository
                .findById(dto.getItem().getId())
                .orElseThrow(()-> new BusnissesRulesException("Codigo do item invalido!"));
        item.setAmount(item.getAmount() + dto.getItem().getQuantidade());
        item.getStocks().add(stock);
        stock.getProducts().add(item);
        itemRepository.save(item);
        return stockRepository.save(stock);
    }

    public List<Stock> findAll(){
        return stockRepository.findAll();
    }
    public Item changeAmount(ItemAmountRequest item, Long id) {
        Stock entity = stockRepository.findById(id)
                .orElseThrow(() -> new BusnissesRulesException("Codigo de estoque invalido!"));
        entity.changeAmount(item);
        stockRepository.save(entity);
        return itemRepository
                .findById(item.getId())
                .orElseThrow(() -> new BusnissesRulesException("Codigo de item invalido!"));
    }
    public List<Stock> saveAll(List<Stock> stocks) {
        return stockRepository.saveAll(stocks);
    }

}
