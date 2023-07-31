package com.consumidor.projetosite.repositories;

import com.consumidor.projetosite.models.Cart;
import com.consumidor.projetosite.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    @Query(value = "select * from tbl_carrinho", nativeQuery = true)
     Item findByItens();
}
