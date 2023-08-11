package com.consumidor.projetosite.services.impl;


import com.consumidor.projetosite.dto.ItemDTO;
import com.consumidor.projetosite.models.Item;
import com.consumidor.projetosite.repositories.ItemRepository;
import com.consumidor.projetosite.repositories.StockRepository;
import com.consumidor.projetosite.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private StockRepository stockRepository;

    public Item save(Item item){
        return itemRepository.save(item);
    }
    public List<Item> saveAll(Iterable<Item> items){
        return itemRepository.saveAll(items);
    }

    public ItemDTO findById(Long id){
       Item entity = itemRepository.findById(id).get();
        return new ItemDTO(entity);
    }
    public Item update(Item item){
        return itemRepository.save(item);
    }
    public void delete(Item item){
        itemRepository.delete(item);
    }

}
