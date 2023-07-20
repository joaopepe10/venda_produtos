package com.consumidor.projetosite.servico;

import com.consumidor.projetosite.repositorio.CarrinhoRepositorio;
import com.consumidor.projetosite.repositorio.EstoqueRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CarrinhoServico {
    @Autowired
    private CarrinhoRepositorio carrinhoRepositorio;
    @Autowired
    private EstoqueRepositorio estoqueRepositorio;



}
