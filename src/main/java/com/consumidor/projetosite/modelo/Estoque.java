package com.consumidor.projetosite.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Component
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_estoque;
    @Column(nullable = false)
    private String categoria;

    @OneToMany(mappedBy = "estoque")
    @Column(nullable = false)
    @JsonIgnore
    List<Item> produtos = new ArrayList<>();

    public void setId_estoque(Long id_estoque) {
        this.id_estoque = id_estoque;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
