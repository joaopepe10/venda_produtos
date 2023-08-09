package com.consumidor.projetosite.models;

import jakarta.persistence.Embedded;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Adress /*implements Serializable*/ {

    private String rua;


    private String bairro;


    private String numero;


    private String cep;

    public Adress() {
    }

    public Adress(String rua, String bairro, String numero, String cep) {
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.cep = cep;

    }

}
