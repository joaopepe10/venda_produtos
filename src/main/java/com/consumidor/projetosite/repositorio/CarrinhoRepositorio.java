package com.consumidor.projetosite.repositorio;

import com.consumidor.projetosite.modelo.Carrinho;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrinhoRepositorio extends CrudRepository<Carrinho, Long> {
}
