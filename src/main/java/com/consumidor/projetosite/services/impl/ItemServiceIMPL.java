package com.consumidor.projetosite.services.impl;


import com.consumidor.projetosite.dto.request.ItemRequest;
import com.consumidor.projetosite.exception.BusnissesRulesException;
import com.consumidor.projetosite.models.Item;
import com.consumidor.projetosite.repositories.ItemRepository;
import com.consumidor.projetosite.repositories.StockRepository;
import com.consumidor.projetosite.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private StockRepository stockRepository;

    public Item save(ItemRequest dto){
        Item item = new Item(dto);
        return itemRepository.save(item);
    }
    public List<Item> saveAll(List<ItemRequest> dtos){
        List<Item> items = convertToItem(dtos);
        return itemRepository.saveAll(items);
    }

    public ItemRequest findById(Long id){
       Item entity = itemRepository.findById(id).
               orElseThrow(() -> new BusnissesRulesException("ID invalido!"));
        return new ItemRequest(entity);
    }
    public void update(Long id, Item i){
        itemRepository.findById(id)
                .ifPresent(itens -> {
                    i.setId(itens.getId());
                    itemRepository.save(i);
                });
    }
    public void delete(Item item){
        itemRepository.delete(item);
    }

    private Item convertToItem(ItemRequest dto){
        return new Item(dto);
    }

    private List<Item> convertToItem(List<ItemRequest> dto){
        List<Item> items = new ArrayList<>();
        for (ItemRequest item : dto) {
            Item item1 = new Item(item.getNome(), item.getPreco());
            items.add(item1);
        }
        return items;
    }
}
