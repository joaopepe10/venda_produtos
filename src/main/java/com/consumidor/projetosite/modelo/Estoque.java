package com.consumidor.projetosite.modelo;


import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Entity
public class Estoque implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String categoria;

    @OneToMany(mappedBy = "estoque")
    @Column(nullable = false)
    private List<Item> produtos = new ArrayList<>();

    public Estoque() {
    }

    public Estoque(Long id_estoque, String categoria) {
        this.id = id_estoque;
        this.categoria = categoria;
    }

    public Estoque(Long id_estoque, String categoria, List<Item> produtos) {
        this.id = id_estoque;
        this.categoria = categoria;
        this.produtos = produtos;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estoque estoque)) return false;
        return Objects.equals(getId(), estoque.getId()) && Objects.equals(getCategoria(), estoque.getCategoria()) && Objects.equals(getProdutos(), estoque.getProdutos());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
