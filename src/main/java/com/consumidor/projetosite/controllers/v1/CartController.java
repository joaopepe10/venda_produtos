package com.consumidor.projetosite.controllers.v1;

import com.consumidor.projetosite.services.CartServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/carrinho")
public class CartController {
    @Autowired
    private CartServiceIMPL cartServiceIMPL;

    @GetMapping("")
    public String bemVindo() {
        return "Seja bem vindo a aba de carrinho!";
    }
    }


