package com.consumidor.projetosite.repositorio;

import com.consumidor.projetosite.modelo.Estoque;
import org.springframework.data.repository.CrudRepository;

public interface EstoqueRepositorio extends CrudRepository<Estoque, Long> {
}
