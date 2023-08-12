package com.consumidor.projetosite.controllers.v1;

import com.consumidor.projetosite.dto.ItemDto;
import com.consumidor.projetosite.models.Item;
import com.consumidor.projetosite.services.impl.ItemServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/item")
public class ItemController {

    @Autowired
    private ItemServiceIMPL itemServiceIMPL;

   /* @GetMapping("/cadastrar-item")
    public ModelAndView saveItemView(@ModelAttribute Item item){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Item/formItem"); //DIRETORIO ONDE ESTA A VIEW
        mv.addObject("item", new Item());
        return mv;
    }

    @PostMapping("salvarItem")
    public ModelAndView saveItem(@RequestBody Item item){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/cadastrar-item");
        itemServiceIMPL.save(item);
        return mv;
    }*/
    @PutMapping("/{id}")
    public void update (@PathVariable Long id,
                        @RequestBody Item item){
        itemServiceIMPL.update(id, item);
    }

    @PostMapping()
    public @ResponseBody Item save(@RequestBody ItemDto item){
        return itemServiceIMPL.save(item);
    }

    @PostMapping("/salvar")
    public List<Item> items(@RequestBody List<ItemDto> items){
        return itemServiceIMPL.saveAll(items);
    }

}
