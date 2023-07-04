package com.consumidor.projetosite.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Entity
@Component
public class Estoque {
    @Id
    private Long id_estoque ;

    @OneToMany
    List<Produto> produtos_em_estoque;
    public Estoque(){
        setId_estoque(1l);
    }
}
