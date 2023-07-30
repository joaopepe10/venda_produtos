package com.consumidor.projetosite.modelo;

import com.consumidor.projetosite.enums.CategoriaEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Estoque implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private CategoriaEnum categoria;

    @OneToMany(mappedBy = "estoque")
    @Column(nullable = false)
    private List<Item> produtos = new ArrayList<>();

    public Estoque(Long id,CategoriaEnum categoria){
        this.categoria = categoria;
    }
}
