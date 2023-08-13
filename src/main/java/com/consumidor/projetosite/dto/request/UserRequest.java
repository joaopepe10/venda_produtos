package com.consumidor.projetosite.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.time.Period;

/*
* {
*   "cpf" : 111.222.333-44
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
    @CPF(message = "Cpf invalido")
    private String cpf;

    @NotEmpty(message = "Campo nome obrigatorio")
    @NotNull(message = "Campo nome nulo")
    private String name;
    private String lastName;
    private Short day;
    private Short month;
    private Short year;
    private String email;
    private String password;

    private Integer calculateAge(Integer day, Integer month, Integer year){
        LocalDate dateNow = LocalDate.now();
        LocalDate birthDay = LocalDate.of(year, month, day);
        return Period.between(birthDay, dateNow).getYears();
    }
}
