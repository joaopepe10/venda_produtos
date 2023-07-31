package com.consumidor.projetosite.controllers.v1;

import com.consumidor.projetosite.services.UserServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/usuario")
public class UserController {
    @Autowired
    private UserServiceIMPL userServiceIMPL;

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        return userServiceIMPL.findAll();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable Long id){
        return userServiceIMPL.findById(id);
    }
}
