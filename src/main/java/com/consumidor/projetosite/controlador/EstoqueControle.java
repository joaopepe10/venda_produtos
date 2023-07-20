package com.consumidor.projetosite.controlador;

import com.consumidor.projetosite.modelo.Item;
import com.consumidor.projetosite.repositorio.EstoqueRepositorio;
import com.consumidor.projetosite.servico.EstoqueServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estoque")
public class EstoqueControle {
    @Autowired
    private EstoqueRepositorio estoqueRepositorio;
    @Autowired
    private EstoqueServico estoqueServico;

    @PostMapping("/cadastrar-item")
    public ResponseEntity<?> cadastro(@RequestBody Item p){
        return estoqueServico.adcProdutoEstoque(p);
    }

    @GetMapping("/listar-todos")
    public ResponseEntity<?> listar(){
        return estoqueServico.findAll();
    }

    @GetMapping("/listar-estoque/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return estoqueServico.findById(id);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> buscar(@PathVariable Long id){
        return estoqueServico.findByProdutosId(id);
    }
}
