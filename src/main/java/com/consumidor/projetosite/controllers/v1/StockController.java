package com.consumidor.projetosite.controllers.v1;


import com.consumidor.projetosite.dto.ItemDTO;
import com.consumidor.projetosite.dto.StockDTO;
import com.consumidor.projetosite.dto.StockIdDTO;
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
    public String saveNewItem(@RequestBody StockDTO dto){
        Stock stock = stockServiceIMPL.saveItem(dto);
        return "Salvo com sucesso o item na categoria " + stock.getCategoria();
    }

    @PatchMapping("/adiciona-item")
    public Stock saveItemWithRelation(@RequestBody StockIdDTO dto){
        Stock stock = stockServiceIMPL.saveItemWithRelation(dto);
        return stock;
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
