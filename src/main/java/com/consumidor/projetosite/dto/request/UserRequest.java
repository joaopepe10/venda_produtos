package com.consumidor.projetosite.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

/*
* {
    "name" : "Joao Pedro",
    "lastName" : " Pires Barcante",
    "day" : 28,
    "month" : 11,
    "year" : 1999,
    "email" : "joao123@gmail.com",
    "password" : 12345678
}
* */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRequest {
    private String name;
    private String lastName;
    private Short day;
    private Short month;
    private Short year;
    private String email;
    private String password;


    private Integer calculaIdade(Integer dia, Integer mes, Integer ano){
        LocalDate dataAtual = LocalDate.now();
        LocalDate dataNascimento = LocalDate.of(ano, mes, dia);
        return Period.between(dataNascimento, dataAtual).getYears();
    }
}
