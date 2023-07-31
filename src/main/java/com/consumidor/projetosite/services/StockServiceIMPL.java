package com.consumidor.projetosite.services;


import com.consumidor.projetosite.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StockServiceIMPL {
    @Autowired
    private StockRepository stockRepository;


    //BUSCA UMA LISTA DE PRODUTOS DE ACORDO COM O ID DO ESTOQUE
    public ResponseEntity<?> findByProdutosId(Long id){
        return new ResponseEntity<>(stockRepository.findByProdutosId(id), HttpStatus.OK);
    }
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(stockRepository.findAll(),HttpStatus.OK);
    }
    public ResponseEntity<?> findById(Long id){
        return new ResponseEntity<>(stockRepository.findById(id),HttpStatus.OK);
    }
}
