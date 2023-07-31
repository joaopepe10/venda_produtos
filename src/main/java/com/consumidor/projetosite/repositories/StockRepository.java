package com.consumidor.projetosite.repositories;

import com.consumidor.projetosite.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    Stock findByCategoria(String categoria);
    List<Stock> findByProdutosId(Long id);
}
