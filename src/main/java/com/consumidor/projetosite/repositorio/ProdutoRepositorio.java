package com.consumidor.projetosite.repositorio;

import com.consumidor.projetosite.modelo.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepositorio extends CrudRepository<Produto, Long> {
}
