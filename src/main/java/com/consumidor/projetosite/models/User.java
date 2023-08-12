package com.consumidor.projetosite.models;

import com.consumidor.projetosite.models.attributes.Adress;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "tbl_users")
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Integer day;

    @Column(nullable = false)
    private Integer month;

    @Column(nullable = false)
    private Integer year;

    @Embedded
    private Adress adress;

    public User() {
    }

    public User(String name, String lastName, String password) {
        this.name = name;
        this.lastName = lastName;
        this.password = password;
    }

    public User(Long id, String name,
                String lastName, String password,
                Integer day, Integer month, Integer year, Adress adress) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.day = day;
        this.month = month;
        this.year = year;
        this.adress = adress;
    }

    public User(Long id, String name,
                String lastName, String password,
                Integer day, Integer month, Integer year, String rua,
                String bairro, String numero, String cep) {

        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.day = day;
        this.month = month;
        this.year = year;
        this.adress.setRoad(rua);
        this.adress.setDistrict(bairro);
        this.adress.setNumber(numero);
        this.adress.setZipCode(cep);
    }


}
