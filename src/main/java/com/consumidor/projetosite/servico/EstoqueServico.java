package com.consumidor.projetosite.servico;

import com.consumidor.projetosite.modelo.Estoque;
import com.consumidor.projetosite.modelo.Produto;
import com.consumidor.projetosite.repositorio.EstoqueRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EstoqueServico {
    @Autowired
    private EstoqueRepositorio estoqueRepositorio;
    @Autowired
    private Estoque estoque;

    public ResponseEntity<?> adcProdutoEstoque(Produto p){
        return new ResponseEntity<>(estoque.getProdutos_em_estoque().add(p), HttpStatus.CREATED);
    }
}
