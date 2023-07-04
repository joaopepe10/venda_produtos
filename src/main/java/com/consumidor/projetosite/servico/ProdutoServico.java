package com.consumidor.projetosite.servico;

import com.consumidor.projetosite.modelo.Produto;
import com.consumidor.projetosite.repositorio.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServico {
    @Autowired
    private ProdutoRepositorio produtoRepositorio;

    public ResponseEntity<?>cadastrarProduto(Produto p){
        if(p.getNome_produto().equals("")){
            return new ResponseEntity<>("Nome invalido!", HttpStatus.BAD_REQUEST);
        } else if (p.getPreco_produto() == 0) {
            return new ResponseEntity<>("Preco invalido!", HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(produtoRepositorio.save(p), HttpStatus.CREATED);
        }
    }
}
