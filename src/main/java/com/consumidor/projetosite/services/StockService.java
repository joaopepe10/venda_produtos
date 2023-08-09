package com.consumidor.projetosite.services;

import com.consumidor.projetosite.models.Item;

public interface StockService {

    String changeQuantity(Item item, Long id);
}
