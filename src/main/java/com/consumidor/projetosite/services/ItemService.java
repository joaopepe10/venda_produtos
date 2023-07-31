package com.consumidor.projetosite.services;

import com.consumidor.projetosite.dto.ItemDTO;
import com.consumidor.projetosite.models.Item;

import java.util.List;

public interface ItemService {

    Item save(Item item);
    Iterable<Item> saveAll(Iterable<Item> items);
    ItemDTO findById(Long id);
    Item update(Item item);
    void delete(Item item);
}
