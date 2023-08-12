package com.consumidor.projetosite.repositories;

import com.consumidor.projetosite.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    @Override
    List<Item> findAll();
}
