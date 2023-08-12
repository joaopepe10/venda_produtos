package com.consumidor.projetosite.controllers.v1;

import com.consumidor.projetosite.dto.request.UserRequest;
import com.consumidor.projetosite.dto.response.UserResponse;
import com.consumidor.projetosite.services.impl.UserServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/usuario")
public class UserController {
    @Autowired
    private UserServiceIMPL userServiceIMPL;

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createUser(@RequestBody UserRequest dto){
        userServiceIMPL.save(dto);
        return new UserResponse(dto);
    }
}
