package com.consumidor.projetosite.dto;

import com.consumidor.projetosite.modelo.Endereco;
import com.consumidor.projetosite.modelo.Usuario;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private Long    id;
    private String    nome;
    private String    sobrenome;
    private Integer     idade;
    private Endereco endereco;

    public UsuarioDTO(Usuario usuario){
        id = usuario.getId();
        nome = usuario.getNome();
        sobrenome =usuario.getSobrenome();
        idade = calculaIdade(usuario.getDia(), usuario.getMes(), usuario.getAno());
        endereco = usuario.getEndereco();
    }

    private Integer calculaIdade(Integer dia, Integer mes, Integer ano){
        LocalDate dataAtual = LocalDate.now();
        LocalDate dataNascimento = LocalDate.of(ano, mes, dia);
        return Period.between(dataNascimento, dataAtual).getYears();
    }
}
