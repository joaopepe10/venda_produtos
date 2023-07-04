package com.consumidor.projetosite.controlador;

import com.consumidor.projetosite.modelo.Produto;
import com.consumidor.projetosite.repositorio.EstoqueRepositorio;
import com.consumidor.projetosite.servico.EstoqueServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estoque")
public class EstoqueControle {
    @Autowired
    private EstoqueRepositorio estoqueRepositorio;
    @Autowired
    private EstoqueServico estoqueServico;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastro(@RequestBody Produto p){
        return estoqueServico.adcProdutoEstoque(p);
    }
}
