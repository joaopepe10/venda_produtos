package com.consumidor.projetosite.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Getter
@Setter
@Entity
public class Carrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_carrinho;

    //UM CARRINHO PARA VARIOS PRODUTOS
    @Autowired
    @OneToMany
    List<Produto> produtos;

}
