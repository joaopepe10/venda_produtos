package com.consumidor.projetosite.servico;


import com.consumidor.projetosite.repositorio.EstoqueRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EstoqueServico {
    @Autowired
    private EstoqueRepositorio estoqueRepositorio;


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
