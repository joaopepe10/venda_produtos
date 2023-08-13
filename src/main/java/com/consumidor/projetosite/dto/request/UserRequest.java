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

    @NotEmpty(message = "Campo CPF obrigatorio")
    @CPF(message = "CPF invalido")
    private String cpf;

    @NotEmpty(message = "Campo nome obrigatorio")
    private String name;

    @NotEmpty(message = "Campo sobrenome obrigatorio")
    private String lastName;

    private Short day;

    private Short month;

    private Short year;

    @NotEmpty(message = "Campo email obrigatorio")
    private String email;

    @NotEmpty(message = "Campo senha obrigatorio")
    private String password;

}
