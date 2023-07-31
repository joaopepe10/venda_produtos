package com.consumidor.projetosite.services;


import com.consumidor.projetosite.dto.ItemDTO;
import com.consumidor.projetosite.models.Item;
import com.consumidor.projetosite.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ItemServiceIMPL implements ItemService{
    @Autowired
    private ItemRepository itemRepository;

    public Item save(Item item){
        return itemRepository.save(item);
    }

    public ItemDTO findById(Long id){
       Item entity = itemRepository.findById(id).get(); //METODO GET UTILIZADO PARA ACESSAR O OBJETO DENTRO DO OPTINAL
        return new ItemDTO(entity);
    }
    public Iterable<Item> saveAll(Iterable<Item> items){
        return itemRepository.saveAll(items);
    }

    public Item update(Item item){
        return itemRepository.save(item);
    }

    public void delete(Item item){
        itemRepository.delete(item);
    }

}
