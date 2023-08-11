package com.consumidor.projetosite.dto;

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
public class ItemIdDTO {
    private Long id;
    private Long quantidade;
}
