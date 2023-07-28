package com.consumidor.projetosite.controlador;

import com.consumidor.projetosite.modelo.Item;
import com.consumidor.projetosite.servico.ItemServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

//CRIANDO ROTA DO ITEM, E INFORMANDO AO SPRING QUE ESSE E UM CONTROLLER
@RestController
@RequestMapping("/item")
public class ItemControle {

    @Autowired
    private ItemServico itemServico;


    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Item item){
        return itemServico.cadastrarItem(item);
    }

    @GetMapping("/cadastrar-item")
    public ModelAndView cadastro(Item item){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Item/formItem");
        mv.addObject("item", new Item());
        return mv;
    }

    @GetMapping("/listar-formatado")
    public String listarFormatado(){
        return itemServico.listarItensFormatado();
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        return itemServico.findAll();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return itemServico.findById(id);
    }
}
