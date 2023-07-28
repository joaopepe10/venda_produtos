package com.consumidor.projetosite.servico;

import com.consumidor.projetosite.modelo.Estoque;
import com.consumidor.projetosite.modelo.Item;
import com.consumidor.projetosite.repositorio.EstoqueRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EstoqueServico {
    @Autowired
    private EstoqueRepositorio estoqueRepositorio;


    public ResponseEntity<?> adcProdutoEstoque(Item item){
        Estoque e = estoqueRepositorio.findByCategoria(item.getEstoque().getCategoria());

        Estoque estoque =  new Estoque();
        estoque.getProdutos().add(item);
        return new ResponseEntity<>(estoqueRepositorio.save(estoque), HttpStatus.CREATED);
    }
    //BUSCA UMA LISTA DE PRODUTOS DE ACORDO COM O ID DO ESTOQUE
    public ResponseEntity<?> findByProdutosId(Long id){
        return new ResponseEntity<>(estoqueRepositorio.findByProdutosId(id), HttpStatus.OK);
    }
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(estoqueRepositorio.findAll(),HttpStatus.OK);
    }
    public ResponseEntity<?> findById(Long id){
        return new ResponseEntity<>(estoqueRepositorio.findById(id),HttpStatus.OK);
    }
}
