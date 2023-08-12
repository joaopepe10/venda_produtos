package com.consumidor.projetosite.controllers.v1;


import com.consumidor.projetosite.dto.ItemAmountDto;
import com.consumidor.projetosite.dto.StockDto;
import com.consumidor.projetosite.dto.StockItemAmountDto;
import com.consumidor.projetosite.models.Item;
import com.consumidor.projetosite.models.Stock;
import com.consumidor.projetosite.repositories.StockRepository;
import com.consumidor.projetosite.services.impl.StockServiceIMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/estoque")
public class StockController {
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private StockServiceIMPL stockServiceIMPL;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Stock save(@RequestBody Stock stock){
        return stockServiceIMPL.save(stock);
    }

    @PostMapping("/salvar")
    public List<Stock> saveAll(@RequestBody List<Stock> stocks){
        return stockServiceIMPL.saveAll(stocks);
    }

    @PatchMapping("/adiciona")
    public String saveNewItem(@RequestBody StockDto dto){
        Stock stock = stockServiceIMPL.saveItem(dto);
        return "Salvo com sucesso o item na categoria " + stock.getCategory();
    }

    @PatchMapping("/adiciona-item")
    public Stock saveItemWithRelation(@RequestBody StockItemAmountDto dto){
        return stockServiceIMPL.saveItemWithRelation(dto);
    }

    @GetMapping()
    public List<Stock> findAll(){
        return stockServiceIMPL.findAll();
    }

    @PatchMapping("/{id}")
    public Item changeAmount(@RequestBody ItemAmountDto item, @PathVariable Long id){
        return stockServiceIMPL.changeAmount(item, id);
    }
}
