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

    public Item salvarItem(Item item){
        return itemRepositorio.save(item);
    }
    public ItemDTO buscarPorId(Long id){
       Item entidade = itemRepositorio.findById(id).get(); //METODO GET UTILIZADO PARA ACESSAR O OBJETO DENTRO DO OPTINAL
       ItemDTO dto = new ItemDTO(entidade); // O RETORNO QUANDO FIZER A BUSCA SERA DO DTO DE ACORDO COM OS ATRIBUTOS EXPOSTOS NA CLASSE itemDTO
        return dto;
    }
}
