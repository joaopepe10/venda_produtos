package com.consumidor.projetosite.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String sobrenome;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private Integer dia;

    @Column(nullable = false)
    private Integer mes;

    @Column(nullable = false)
    private Integer ano;

    @OneToOne
    @JoinColumn(name = "id_endereco_FK", referencedColumnName = "id_endereco_PK")
    private Adress adress;

    public User() {
    }

    public User(String nome_usuario, String sobrenome_usuario, String senha) {
        this.nome = nome_usuario;
        this.sobrenome = sobrenome_usuario;
        this.senha = senha;
    }

    public User(Long id_user_PK, String nome_usuario,
                String sobrenome_usuario, String senha,
                Integer dia, Integer mes, Integer ano, Adress adress) {
        this.id = id_user_PK;
        this.nome = nome_usuario;
        this.sobrenome = sobrenome_usuario;
        this.senha = senha;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.adress = adress;
    }

    public User(Long id_user_PK, String nome_usuario,
                String sobrenome_usuario, String senha,
                Integer dia, Integer mes, Integer ano, String rua,
                String bairro, String numero, String cep) {

        this.id = id_user_PK;
        this.nome = nome_usuario;
        this.sobrenome = sobrenome_usuario;
        this.senha = senha;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.adress.setRua(rua);
        this.adress.setBairro(bairro);
        this.adress.setNumero(numero);
        this.adress.setCep(cep);
    }


}
