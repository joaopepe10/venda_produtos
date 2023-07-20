package com.consumidor.projetosite.controlador;

import com.consumidor.projetosite.modelo.Item;
import com.consumidor.projetosite.servico.CarrinhoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoControle {
    @Autowired
    private CarrinhoServico carrinhoServico;

    @GetMapping("")
    public String bemVindo() {
        return "Seja bem vindo a aba de carrinho!";
    }
    }


