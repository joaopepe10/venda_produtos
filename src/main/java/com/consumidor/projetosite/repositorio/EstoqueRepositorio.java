package com.consumidor.projetosite.repositorio;

import com.consumidor.projetosite.modelo.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstoqueRepositorio extends JpaRepository<Estoque, Long> {
    Estoque findByCategoria(String categoria);
    List<Estoque> findByProdutosId(Long id);
}
