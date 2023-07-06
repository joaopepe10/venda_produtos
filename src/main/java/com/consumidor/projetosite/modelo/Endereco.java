package com.consumidor.projetosite.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Endereco {
    @Id
    private Long id_endereco_PK;
    private String rua;
    private String bairro;
    private String numero;
    private String cep;

   @OneToOne(mappedBy = "endereco")
    private Usuario usuario;

}
