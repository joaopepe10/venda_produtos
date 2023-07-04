package com.consumidor.projetosite.repositorio;

import com.consumidor.projetosite.modelo.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepositorio extends CrudRepository<Produto, Long> {
}
