package com.consumidor.projetosite.servico;

import com.consumidor.projetosite.modelo.Estoque;
import com.consumidor.projetosite.modelo.Item;
import com.consumidor.projetosite.repositorio.EstoqueRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstoqueServico {
    @Autowired
    private EstoqueRepositorio estoqueRepositorio;


    public ResponseEntity<?> adcProdutoEstoque(Item item){
        Estoque estoque = new Estoque();
        List<Item>produtos = new ArrayList<>();

        produtos.add(item);
        estoque.getProdutos().add(item);
        return new ResponseEntity<>(estoqueRepositorio.save(estoque), HttpStatus.CREATED);
    }

    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(estoqueRepositorio.findAll(),HttpStatus.OK);
    }
    public ResponseEntity<?> findById(Long id){
        return new ResponseEntity<>(estoqueRepositorio.findById(id),HttpStatus.OK);
    }
}
