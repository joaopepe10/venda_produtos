package com.consumidor.projetosite.servico;

import com.consumidor.projetosite.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServico {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(usuarioRepositorio.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<?> findById(Long id){
        return new ResponseEntity<>(usuarioRepositorio.findById(id),HttpStatus.OK);
    }
}
