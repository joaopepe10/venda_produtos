package com.consumidor.projetosite.repositorio;

import com.consumidor.projetosite.modelo.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ItemRepositorio extends CrudRepository<Item, Long> {
    @Override
    List<Item> findAll();
}
