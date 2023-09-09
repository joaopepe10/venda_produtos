package com.consumidor.projetosite.services;

import com.consumidor.projetosite.dto.ItemDto;
import com.consumidor.projetosite.models.Item;

import java.util.List;


public interface ItemService {

    Item save(ItemDto item);
    List<Item> saveAll(List<ItemDto> dtos);
    ItemDto findById(Long id);
    void update(Long id, Item i);
    void deleteById(Long id);
}
