package com.consumidor.projetosite.services.impl;

import com.consumidor.projetosite.models.Item;
import com.consumidor.projetosite.models.Stock;
import com.consumidor.projetosite.repositories.ItemRepository;
import com.consumidor.projetosite.repositories.StockRepository;
import com.consumidor.projetosite.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    public Stock saveItem(Long id,Item item){
        Stock entity = stockRepository.findById(id).get();
        entity.getProdutos().add(item);
        return stockRepository.save(entity);
    }
    public List<Stock> findAll(){
        return stockRepository.findAll();
    }

    @Override
    public String changeQuantity(Item item, Long id) {
        Stock entity = stockRepository.findById(id).get();
        entity.changeQuantity(item);
        stockRepository.save(entity);
        return "Quantidade alterada!";
    }
}
