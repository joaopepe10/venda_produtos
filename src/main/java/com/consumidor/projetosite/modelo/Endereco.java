package com.consumidor.projetosite.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_endereco_PK;
    private String rua;
    private String bairro;
    private String numero;
    private String cep;

   @OneToOne(mappedBy = "endereco")
    private Usuario usuario;

    public Endereco() {
    }

    public Endereco(String rua, String bairro, String numero, String cep) {
        this.id_endereco_PK = null;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.cep = cep;

    }
}
