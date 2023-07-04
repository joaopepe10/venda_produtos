package com.consumidor.projetosite.controlador;

import com.consumidor.projetosite.modelo.Produto;
import com.consumidor.projetosite.repositorio.ProdutoRepositorio;
import com.consumidor.projetosite.servico.ProdutoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoControle {
    @Autowired
    private ProdutoRepositorio produtoRepositorio;

    @Autowired
    private ProdutoServico produtoServico;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarProduto(@RequestBody Produto p){
        return produtoServico.cadastrarProduto(p);
    }
}
