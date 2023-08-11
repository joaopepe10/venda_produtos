package com.consumidor.projetosite.controllers.v1;

import com.consumidor.projetosite.models.Item;

import com.consumidor.projetosite.services.ItemService;
import com.consumidor.projetosite.services.impl.ItemServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//CRIANDO ROTA DO ITEM, E INFORMANDO AO SPRING QUE ESSE E UM CONTROLLER
@RestController
@RequestMapping("/api/v1/item")
public class ItemController {

    @Autowired
    private ItemServiceIMPL itemServiceIMPL;

    @GetMapping("/cadastrar") //
    public ModelAndView cadastro(@ModelAttribute Item item){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Item/formItem"); //DIRETORIO ONDE ESTA A VIEW
        mv.addObject("item", new Item());
        return mv;
    }

    @PostMapping("salvarItem")
    public ModelAndView salvarItem(@RequestBody Item item){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/cadastrar-item");
        itemServiceIMPL.save(item);
        return mv;
    }

    @PostMapping()
    public @ResponseBody Item salvar(@RequestBody Item item){
        return itemServiceIMPL.save(item);
    }

    @PostMapping("/salvar")
    public @ResponseBody List<Item> items(@RequestBody List<Item> items){
        return itemServiceIMPL.saveAll(items);
    }

}
