package com.consumidor.projetosite.repositorio;

import com.consumidor.projetosite.modelo.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepositorio extends CrudRepository<Endereco,Long> {
}
