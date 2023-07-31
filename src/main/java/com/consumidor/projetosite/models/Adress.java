package com.consumidor.projetosite.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "tbl_adress")
public class Adress implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_endereco_PK;

    @Column(nullable = false)
    private String rua;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false)
    private String numero;

    @Column(nullable = false)
    private String cep;

   @OneToOne(mappedBy = "adress")
   @JsonIgnore //A TABELA QUE VOCE DESEJA QUE APARECA EM OUTRA TABELA QUE DEVE CONTER A ANOTTATION @JsonIgnore
    private User usuario;

    public Adress() {
    }

    public Adress(String rua, String bairro, String numero, String cep) {
        this.id_endereco_PK = null;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.cep = cep;

    }

}
