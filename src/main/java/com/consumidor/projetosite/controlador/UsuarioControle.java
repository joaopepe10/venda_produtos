package com.consumidor.projetosite.controlador;

import com.consumidor.projetosite.servico.UsuarioServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioControle {
    @Autowired
    private UsuarioServico usuarioServico;

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        return usuarioServico.findAll();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return usuarioServico.findById(id);
    }
}
