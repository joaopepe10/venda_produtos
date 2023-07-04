package com.consumidor.projetosite.repositorio;

import com.consumidor.projetosite.modelo.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepositorio extends CrudRepository<Item, Long> {
    @Override
    List<Item> findAll();
}
