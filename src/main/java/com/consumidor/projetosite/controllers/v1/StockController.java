package com.consumidor.projetosite.controllers.v1;


import com.consumidor.projetosite.dto.request.item.ItemAmountRequest;
import com.consumidor.projetosite.dto.request.stock.StockRequest;
import com.consumidor.projetosite.dto.request.stock.StockRequestItem;
import com.consumidor.projetosite.dto.request.stock.StockItemAmountRequest;
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
    @ResponseStatus(HttpStatus.CREATED)
    public List<Stock> saveAll(@RequestBody List<StockRequest> dtos){
        return stockServiceIMPL.saveAll(dtos);
    }

    @PatchMapping("/adiciona")
    @ResponseStatus(HttpStatus.OK)
    public String saveNewItem(@RequestBody StockRequestItem dto){
        Stock stock = stockServiceIMPL.saveItem(dto);
        return "Salvo com sucesso o item na categoria " + stock.getCategory();
    }

    @PatchMapping("/adiciona-item")
    @ResponseStatus(HttpStatus.OK)
    public Stock saveItemWithRelation(@RequestBody StockItemAmountRequest dto){
        return stockServiceIMPL.saveItemWithRelation(dto);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Stock> findAll(){
        return stockServiceIMPL.findAll();
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Item changeAmount(@RequestBody ItemAmountRequest item, @PathVariable Long id){
        return stockServiceIMPL.changeAmount(item, id);
    }
}
