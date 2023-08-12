package com.consumidor.projetosite.enums;

public enum CategoryENUM {
    INFORMATICA(1),
    PERFUME(2),
    CALCADO(3);

    private Integer codigo;
    private CategoryENUM(Integer codigo){
        this.codigo = codigo;
    }

    public Integer getCodigo(){
        return this.codigo;
    }
}
