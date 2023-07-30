package com.consumidor.projetosite.controlador;

import com.consumidor.projetosite.modelo.Item;
import com.consumidor.projetosite.servico.ItemServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

//CRIANDO ROTA DO ITEM, E INFORMANDO AO SPRING QUE ESSE E UM CONTROLLER
@RestController
@RequestMapping("/item")
public class ItemControle {

    @Autowired
    private ItemServico itemServico;


    @GetMapping
    public String home(){
        return "Ola mundo!";
    }

    @GetMapping("/cadastrar-item") //
    public ResponseEntity<ModelAndView> cadastro(Item item){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Item/formItem"); //DIRETORIO ONDE ESTA A VIEW
        mv.addObject("item", new Item());
        return new ResponseEntity<>(mv, HttpStatus.OK);
    }

    @PostMapping("salvarItem")
    public ResponseEntity<ModelAndView> salvarItem(Item item){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/cadastrar-item");
        itemServico.salvarItem(item);
        return new ResponseEntity<>(mv, HttpStatus.CREATED);
    }

}
