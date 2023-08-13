package com.consumidor.projetosite.services;

import com.consumidor.projetosite.dto.request.ItemRequest;
import com.consumidor.projetosite.models.Item;

import java.util.List;


public interface ItemService {

    Item save(ItemRequest item);
    List<Item> saveAll(List<ItemRequest> dtos);
    ItemRequest findById(Long id);
    void update(Long id, Item i);
    void delete(Item item);
}
