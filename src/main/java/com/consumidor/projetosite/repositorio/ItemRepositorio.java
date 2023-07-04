package com.consumidor.projetosite.repositorio;

import com.consumidor.projetosite.modelo.Item;
import org.springframework.data.repository.CrudRepository;


public interface ItemRepositorio extends CrudRepository<Item, Long> {
}
