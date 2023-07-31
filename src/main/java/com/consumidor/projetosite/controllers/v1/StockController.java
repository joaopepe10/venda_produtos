package com.consumidor.projetosite.controllers.v1;


import com.consumidor.projetosite.repositories.StockRepository;
import com.consumidor.projetosite.services.StockServiceIMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/estoque")
public class StockController {
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private StockServiceIMPL stockServiceIMPL;
}
