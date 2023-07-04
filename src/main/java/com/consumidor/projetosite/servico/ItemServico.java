package com.consumidor.projetosite.servico;

import com.consumidor.projetosite.modelo.Item;
import com.consumidor.projetosite.repositorio.ItemRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ItemServico {
    @Autowired
    private ItemRepositorio itemRepositorio;

    public ResponseEntity<?> cadastrarItem(Item item){
        return new ResponseEntity<>(itemRepositorio.save(item), HttpStatus.CREATED);
    }
}
