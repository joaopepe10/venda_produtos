/*

package com.consumidor.projetosite.config;


import com.consumidor.projetosite.enums.CategoryENUM;
import com.consumidor.projetosite.models.*;
import com.consumidor.projetosite.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
*/
/*@Profile("test")*//*

public class TestConfig implements CommandLineRunner {
    //CLASSE DE TESTE PARA POPULAR O BANCO DE DADOS, COM DADOS JA PREDEFINIDOS
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @Override
    public void run(String... args) throws Exception {

        Stock smarthPhones = new Stock(null, CategoryENUM.INFORMATICA);
        Stock calcados = new Stock(null, CategoryENUM.CALCADO);
        Stock jogos = new Stock(null, CategoryENUM.INFORMATICA);
        Stock perfumes = new Stock(null, CategoryENUM.PERFUME);
        Cart cart = new Cart();
        cart.setQuantidade(12);

        stockRepository.saveAll(Arrays.asList(smarthPhones, calcados, jogos, perfumes));
        cartRepository.save(cart);

        Item i1 = new Item(null, "Iphone 12", 1333.23f,23L ,smarthPhones);
        Item i8 = new Item(null, "Iphone 13", 2333.23f,33L ,smarthPhones);
        Item i2 = new Item(null, "Air Jordan 1", 747.23f, 12L,calcados);
        Item i3 = new Item(null, "212 vip", 433.33f, 2L,perfumes);
        Item i4 = new Item(null, "Fortinite", 0f, 10L,jogos);
        Item i5 = new Item(null, "Air Jordan 4", 933.23f, 22L,calcados);
        Item i6 = new Item(null, "Mario Kart", 333.23f, 12L,jogos);
        Item i7 = new Item(null, "Chanel", 333.23f, 12L,perfumes);
        itemRepository.saveAll(Arrays.asList(i1, i2, i3, i4, i5, i6, i7, i8));

        cart.getItens().add(i1);

        cart.setQuantidade(10);

        Adress adress1 = new Adress("av do contorno", "barro preto","10320","30110017");

        User u1 = new User(null, "Joao Pedro", "Pires",
                            "123456", 28, 11, 1999, adress1);
        userRepository.save(u1);
    }
}

*/
