package com.consumidor.projetosite.services;

import com.consumidor.projetosite.dto.ItemDTO;
import com.consumidor.projetosite.models.Item;


public interface ItemService {

    Item save(Item item);
    Iterable<Item> saveAll(Iterable<Item> items);
    ItemDTO findById(Long id);
    void update(Long id, Item i);
    void delete(Item item);
}
