package com.consumidor.projetosite.services.impl;


import com.consumidor.projetosite.dto.ItemDto;
import com.consumidor.projetosite.exception.BusnissesRulesException;
import com.consumidor.projetosite.models.Item;
import com.consumidor.projetosite.repositories.ItemRepository;
import com.consumidor.projetosite.repositories.StockRepository;
import com.consumidor.projetosite.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceIMPL implements ItemService {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private StockRepository stockRepository;

    public Item save(ItemDto dto){
        Item item = new Item(dto);
        return itemRepository.save(item);
    }
    public List<Item> saveAll(List<ItemDto> dtos){
        List<Item> items = convertToItem(dtos);
        return itemRepository.saveAll(items);
    }

    public ItemDto findById(Long id){
       Item entity = itemRepository.findById(id).
               orElseThrow(() -> new BusnissesRulesException("ID invalido!"));
        return new ItemDto(entity);
    }

    public List<ItemDto> findAll(){
        List<ItemDto> dtoList = new ArrayList<>();
        itemRepository.findAll().stream()
                .forEach(item -> dtoList.add( new ItemDto(item)));
        return dtoList;
    }
    public void update(Long id, Item i){
        itemRepository.findById(id)
                .ifPresent(itens -> {
                    i.setId(itens.getId());
                    itemRepository.save(i);
                });
    }
    public void deleteById(Long id){
        itemRepository.deleteById(id);
    }

    private Item convertToItem(ItemDto dto){
        return new Item(dto);
    }

    private List<Item> convertToItem(List<ItemDto> dto){
        List<Item> items = new ArrayList<>();
        for (ItemDto item : dto) {
            Item item1 = new Item(item.getNome(), item.getPreco());
            items.add(item1);
        }
        return items;
    }
}
