package com.consumidor.projetosite.enums;

public enum CategoriaEnum{
    INFORMATICA(1),
    PERFUME(2),
    CALCADO(3);

    private Integer codigo;
    private CategoriaEnum(Integer codigo){
        this.codigo = codigo;
    }

    public Integer getCodigo(){
        return this.codigo;
    }
}
