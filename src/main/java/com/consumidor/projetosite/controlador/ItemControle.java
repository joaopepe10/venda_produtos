package com.consumidor.projetosite.controlador;

import com.consumidor.projetosite.modelo.Item;
import com.consumidor.projetosite.repositorio.ItemRepositorio;
import com.consumidor.projetosite.servico.ItemServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemControle {
    @Autowired
    private ItemRepositorio itemRepositorio;
    @Autowired
    private ItemServico itemServico;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Item item){
        return itemServico.cadastrarItem(item);
    }
}
