package com.consumidor.projetosite.dto.request.item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/*
* {
    "id":1,
    "item":{
        "id":1,
        "quantidade":12
    }
}
* */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemAmountRequest {
    private Long id;
    private Long quantidade;
}
