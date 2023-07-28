package com.consumidor.projetosite.servico;


import com.consumidor.projetosite.dto.ItemDTO;
import com.consumidor.projetosite.modelo.Item;
import com.consumidor.projetosite.repositorio.ItemRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


@Service
public class ItemServico {
    @Autowired
    private ItemRepositorio itemRepositorio;

    public ItemDTO buscarPorId(Long id){
       Item entidade = itemRepositorio.findById(id).get();

        return
    }
}
