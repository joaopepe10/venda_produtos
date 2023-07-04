package com.consumidor.projetosite.repositorio;

import com.consumidor.projetosite.modelo.Estoque;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepositorio extends CrudRepository<Estoque, Long> {
}
