package com.consumidor.projetosite.servico;

import com.consumidor.projetosite.modelo.Item;
import com.consumidor.projetosite.repositorio.ItemRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServico {
    @Autowired
    private ItemRepositorio itemRepositorio;

    public ResponseEntity<?> cadastrarItem(Item item){
        if(item.getNome().equals("")){
            return new ResponseEntity<>("Nome invalido!", HttpStatus.BAD_REQUEST);
        } else if (item.getPreco() <= 0 || item.getPreco().equals("")) {
            return new ResponseEntity<>("Preco invalido!", HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(itemRepositorio.save(item), HttpStatus.CREATED);
        }
    }
    public String listarItensFormatado(){
        List<Item> itens = itemRepositorio.findAll();
        String inf = "";
        for (Item i: itens){
            inf += "Codigo do Produto: " + i.getId() +
                    "Nome Produto: " + i.getNome() +
                    "Preco Produto: " + i.getPreco();
        }
        return inf;
    }
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(itemRepositorio.findAll(),HttpStatus.OK);
    }
    public ResponseEntity<?> findById(Long id){
        return new ResponseEntity<>(itemRepositorio.findById(id),HttpStatus.OK);
    }
}
