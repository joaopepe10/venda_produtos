package com.consumidor.projetosite.models.attributes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Adress {

    private String road;


    private String district;


    private String number;


    private String zipCode;

    public Adress() {
    }

    public Adress(String road, String district, String number, String zipCode) {
        this.road = road;
        this.district = district;
        this.number = number;
        this.zipCode = zipCode;

    }

}
