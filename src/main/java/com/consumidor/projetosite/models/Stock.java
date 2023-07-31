package com.consumidor.projetosite.models;

import com.consumidor.projetosite.enums.CategoryENUM;
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
@Table(name = "tbl_stock")
public class Stock implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private CategoryENUM categoria;

    @OneToMany(mappedBy = "stock")
    @Column(nullable = false)
    private List<Item> produtos = new ArrayList<>();

    public Stock(Long id, CategoryENUM categoria){
        this.categoria = categoria;
    }
}
