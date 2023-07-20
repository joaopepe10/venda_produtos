package com.consumidor.projetosite.repositorio;

import com.consumidor.projetosite.modelo.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepositorio extends JpaRepository<Endereco,Long> {
}
