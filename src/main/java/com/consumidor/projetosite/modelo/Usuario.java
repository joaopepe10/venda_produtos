package com.consumidor.projetosite.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Usuario implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToOne
    @JoinColumn(name = "id_endereco_FK", referencedColumnName = "id_endereco_PK")
    private Endereco endereco;

    public Usuario() {
    }

    public Usuario(String nome_usuario, String sobrenome_usuario, String senha) {
        this.nome_usuario = nome_usuario;
        this.sobrenome_usuario = sobrenome_usuario;
        this.senha = senha;
    }

    public Usuario(Long id_user_PK, String nome_usuario, String sobrenome_usuario, String senha, Integer dia, Integer mes, Integer ano, Endereco endereco) {
        this.id_user_PK = id_user_PK;
        this.nome_usuario = nome_usuario;
        this.sobrenome_usuario = sobrenome_usuario;
        this.senha = senha;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.endereco = endereco;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario usuario)) return false;
        return Objects.equals(getId_user_PK(), usuario.getId_user_PK()) && Objects.equals(getNome_usuario(), usuario.getNome_usuario()) && Objects.equals(getSobrenome_usuario(), usuario.getSobrenome_usuario()) && Objects.equals(getSenha(), usuario.getSenha()) && Objects.equals(getDia(), usuario.getDia()) && Objects.equals(getMes(), usuario.getMes()) && Objects.equals(getAno(), usuario.getAno()) && Objects.equals(getEndereco(), usuario.getEndereco());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_user_PK());
    }
}
