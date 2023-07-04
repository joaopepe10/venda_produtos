package com.consumidor.projetosite.controlador;

import com.consumidor.projetosite.modelo.Produto;
import com.consumidor.projetosite.repositorio.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProdutoControle {
    @Autowired
    private ProdutoRepositorio produtoRepositorio;

    @GetMapping("/produto")
    public Iterable<Produto> listarProdutos(){
        return produtoRepositorio.findAll();
    }
}
