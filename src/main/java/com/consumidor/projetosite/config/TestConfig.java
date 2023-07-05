package com.consumidor.projetosite.config;

import com.consumidor.projetosite.modelo.Estoque;
import com.consumidor.projetosite.modelo.Item;
import com.consumidor.projetosite.repositorio.EstoqueRepositorio;
import com.consumidor.projetosite.repositorio.ItemRepositorio;
import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    //CLASSE DE TESTE PARA POPULAR O BANCO DE DADOS, COM DADOS JA PREDEFINIDOS
    @Autowired
    private ItemRepositorio itemRepositorio;
    @Autowired
    private EstoqueRepositorio estoqueRepositorio;

    @Override
    public void run(String... args) throws Exception {
        Estoque e1 = new Estoque(null,"Eletronicos");
        Estoque e2 = new Estoque(null,"Calcados");
        estoqueRepositorio.saveAll(Arrays.asList(e1, e2));

        Item i1 = new Item(null, "Celular", 1333.23f,23L ,e1);
        Item i2 = new Item(null, "Tenis", 333.23f, 12L,e1);

        itemRepositorio.saveAll(Arrays.asList(i1,i2));

    }

}
