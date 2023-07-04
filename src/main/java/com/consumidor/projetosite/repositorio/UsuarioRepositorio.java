package com.consumidor.projetosite.repositorio;
import com.consumidor.projetosite.modelo.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {
}
