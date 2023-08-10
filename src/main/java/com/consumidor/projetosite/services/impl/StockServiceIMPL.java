package com.consumidor.projetosite.services.impl;

import com.consumidor.projetosite.dto.StockDTO;
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
    public Stock saveItem(StockDTO dto){
       Item item = new Item(dto.getItem());
        Stock stock = stockRepository
                .findById(dto.getId())
                .orElseThrow(()-> new BusnissesRulesException("Codigo de estoque invalido!"));
        itemRepository.save(item);
        stock.getProdutos().add(item);
    return stockRepository.save(stock);
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
