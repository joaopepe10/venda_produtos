package com.consumidor.projetosite.controllers.v1;

import com.consumidor.projetosite.dto.request.UserRequest;
import com.consumidor.projetosite.models.User;
import com.consumidor.projetosite.models.attributes.Adress;
import com.consumidor.projetosite.repositories.UserRepository;
import com.consumidor.projetosite.services.impl.UserServiceIMPL;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/usuario")
public class UserController {
    @Autowired
    private UserServiceIMPL userServiceIMPL;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody @Valid UserRequest dto){
        return userServiceIMPL.save(dto);
    }

    @GetMapping("/{id}")
    public User findByCpf(@PathVariable Long id){
        return userServiceIMPL.findById(id);
    }

    @PatchMapping("/cadastrar/endereco/{id}")
    public ResponseEntity<Adress> updateAdress(@PathVariable  Long id,
                                               @RequestBody @Valid Adress adress){
        return new ResponseEntity<>(userServiceIMPL.updadeAdress(id, adress), HttpStatus.ACCEPTED);
    }
}
