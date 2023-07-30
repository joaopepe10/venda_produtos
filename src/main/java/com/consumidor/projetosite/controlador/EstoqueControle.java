package com.consumidor.projetosite.controlador;


import com.consumidor.projetosite.repositorio.EstoqueRepositorio;
import com.consumidor.projetosite.servico.EstoqueServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estoque")
public class EstoqueControle {
    @Autowired
    private EstoqueRepositorio estoqueRepositorio;
    @Autowired
    private EstoqueServico estoqueServico;
}
