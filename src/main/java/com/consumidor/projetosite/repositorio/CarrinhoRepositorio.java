package com.consumidor.projetosite.repositorio;

import com.consumidor.projetosite.modelo.Carrinho;
import com.consumidor.projetosite.modelo.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarrinhoRepositorio extends JpaRepository<Carrinho, Long> {
    @Query(value = "select * from tbl_carrinho", nativeQuery = true)
     Item findByItens();
}
