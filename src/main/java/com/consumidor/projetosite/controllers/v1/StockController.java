package com.consumidor.projetosite.controllers.v1;


import com.consumidor.projetosite.models.Item;
import com.consumidor.projetosite.models.Stock;
import com.consumidor.projetosite.repositories.StockRepository;
import com.consumidor.projetosite.services.impl.StockServiceIMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/estoque")
public class StockController {
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private StockServiceIMPL stockServiceIMPL;

    @PostMapping("/salvar")
    public Stock save(@RequestBody Stock stock){
        return stockServiceIMPL.save(stock);
    }
    @PutMapping("/adiciona")
    public Stock saveItem(@RequestBody Stock dto){

        return stockServiceIMPL.saveItem();
    }

    @GetMapping("/")
    public List<Stock> findAll(){
        return stockServiceIMPL.findAll();
    }



    @PatchMapping("/{id}")
    public Stock changeQuantity(@RequestBody Item item, @PathVariable Long id){
        stockServiceIMPL.changeQuantity(item, id);
        return stockRepository.findByCategoria(String.valueOf(id));
    }




}
