package com.consumidor.projetosite.modelo;

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
public class Endereco implements Serializable {
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

   @OneToOne(mappedBy = "endereco")
   @JsonIgnore //A TABELA QUE VOCE DESEJA QUE APARECA EM OUTRA TABELA QUE DEVE CONTER A ANOTTATION @JsonIgnore
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Endereco endereco)) return false;
        return Objects.equals(getId_endereco_PK(), endereco.getId_endereco_PK()) && Objects.equals(getRua(), endereco.getRua()) && Objects.equals(getBairro(), endereco.getBairro()) && Objects.equals(getNumero(), endereco.getNumero()) && Objects.equals(getCep(), endereco.getCep()) && Objects.equals(getUsuario(), endereco.getUsuario());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_endereco_PK());
    }
}
