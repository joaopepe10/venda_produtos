package com.consumidor.projetosite.config;

import com.consumidor.projetosite.modelo.*;
import com.consumidor.projetosite.repositorio.*;
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

    @Autowired
    private CarrinhoRepositorio carrinhoRepositorio;

    @Override
    public void run(String... args) throws Exception {
       Estoque smarthPhones = new Estoque(null,"Smartphones");
        Estoque calcados = new Estoque(null,"Calcados");
        Estoque jogos = new Estoque(null,"Jogos");
        Estoque perfumes = new Estoque(null,"Perfumes");
        Carrinho carrinho = new Carrinho();
        carrinho.setQuantidadeRequerida(12);

        estoqueRepositorio.saveAll(Arrays.asList(smarthPhones, calcados, jogos, perfumes));
        carrinhoRepositorio.save(carrinho);

        Item i1 = new Item(null, "Iphone 12", 1333.23f,23L ,smarthPhones);
        Item i8 = new Item(null, "Iphone 13", 2333.23f,33L ,smarthPhones);
        Item i2 = new Item(null, "Air Jordan 1", 747.23f, 12L,calcados);
        Item i3 = new Item(null, "212 vip", 433.33f, 2L,perfumes);
        Item i4 = new Item(null, "Fortinite", 0f, 10L,jogos);
        Item i5 = new Item(null, "Air Jordan 4", 933.23f, 22L,calcados);
        Item i6 = new Item(null, "Mario Kart", 333.23f, 12L,jogos);
        Item i7 = new Item(null, "Chanel", 333.23f, 12L,perfumes);
        itemRepositorio.saveAll(Arrays.asList(i1, i2, i3, i4, i5, i6, i7, i8));

        //Adiciona o item 1 ao carrinho
        carrinho.getItens().add(i1);

        //Informa a quantidade de itens
        carrinho.setQuantidadeRequerida(10);

        Endereco endereco1 = new Endereco("av do contorno", "barro preto","10320","30110017");
        enderecoRepositorio.save(endereco1);

        Usuario u1 = new Usuario(null, "Joao Pedro", "Pires",
                            "123456", 28, 11, 1999, endereco1);
        usuarioRepositorio.save(u1);
    }
}
