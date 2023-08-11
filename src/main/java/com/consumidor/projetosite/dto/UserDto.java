package com.consumidor.projetosite.dto;

import com.consumidor.projetosite.models.Adress;
import com.consumidor.projetosite.models.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long    id;
    private String    nome;
    private String    sobrenome;
    private Integer     idade;
    private Adress adress;

    public UserDto(User usuario){
        id = usuario.getId();
        nome = usuario.getNome();
        sobrenome =usuario.getSobrenome();
        idade = calculaIdade(usuario.getDia(), usuario.getMes(), usuario.getAno());
        adress = usuario.getAdress();
    }

    private Integer calculaIdade(Integer dia, Integer mes, Integer ano){
        LocalDate dataAtual = LocalDate.now();
        LocalDate dataNascimento = LocalDate.of(ano, mes, dia);
        return Period.between(dataNascimento, dataAtual).getYears();
    }
}
