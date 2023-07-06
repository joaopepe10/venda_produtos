package com.consumidor.projetosite.config;

import com.consumidor.projetosite.modelo.Endereco;
import com.consumidor.projetosite.modelo.Estoque;
import com.consumidor.projetosite.modelo.Item;
import com.consumidor.projetosite.modelo.Usuario;
import com.consumidor.projetosite.repositorio.EnderecoRepositorio;
import com.consumidor.projetosite.repositorio.EstoqueRepositorio;
import com.consumidor.projetosite.repositorio.ItemRepositorio;
import com.consumidor.projetosite.repositorio.UsuarioRepositorio;
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

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private EnderecoRepositorio enderecoRepositorio;

    @Override
    public void run(String... args) throws Exception {
        Estoque e1 = new Estoque(null,"Eletronicos");
        Estoque e2 = new Estoque(null,"Calcados");
        estoqueRepositorio.saveAll(Arrays.asList(e1, e2));

        Item i1 = new Item(null, "Celular", 1333.23f,23L ,e1);
        Item i2 = new Item(null, "Tenis", 333.23f, 12L,e2);

        itemRepositorio.saveAll(Arrays.asList(i1,i2));

        Endereco endereco1 = new Endereco("av do contorno", "barro preto","10320","30110017");
        enderecoRepositorio.save(endereco1);

        Usuario u1 = new Usuario(null, "Joao Pedro", "Pires", "123456", 28, 11, 1999, endereco1);
        usuarioRepositorio.save(u1);
    }

}
