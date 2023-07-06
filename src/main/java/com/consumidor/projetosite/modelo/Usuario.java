package com.consumidor.projetosite.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class Usuario implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user_PK;

    @Column(nullable = false)
    private String nome_usuario;

    @Column(nullable = false)
    private String sobrenome_usuario;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private Integer dia;

    @Column(nullable = false)
    private Integer mes;

    @Column(nullable = false)
    private Integer ano;

    @Column(nullable = false)
    private Endereco endereco;

    public Usuario() {
    }

    public Usuario(String nome_usuario, String sobrenome_usuario, String senha) {
        this.nome_usuario = nome_usuario;
        this.sobrenome_usuario = sobrenome_usuario;
        this.senha = senha;
    }

    public Usuario(Long id_user_PK, String nome_usuario,
                   String sobrenome_usuario, String senha,
                   Integer dia, Integer mes, Integer ano, String rua,
                   String bairro, String numero, String cep) {

        this.id_user_PK = id_user_PK;
        this.nome_usuario = nome_usuario;
        this.sobrenome_usuario = sobrenome_usuario;
        this.senha = senha;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.endereco.setRua(rua);
        this.endereco.setBairro(bairro);
        this.endereco.setNumero(numero);
        this.endereco.setCep(cep);
    }
}
