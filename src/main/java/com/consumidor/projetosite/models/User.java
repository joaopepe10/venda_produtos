package com.consumidor.projetosite.models;

import com.consumidor.projetosite.dto.request.UserRequest;
import com.consumidor.projetosite.models.attributes.Adress;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_users")
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(length = 15)
    private String cpf;

    private String name;

    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private Short birthDay;

    private Short birthMonth;

    private Short birthYear;

    @Embedded
    private Adress adress;

    public User(UserRequest dto){
        this.cpf = dto.getCpf();
        this.name = dto.getName();
        this.lastName = dto.getLastName();
        this.birthDay = dto.getDay();
        this.birthMonth = dto.getMonth();
        this.birthYear = dto.getYear();
        this.email = dto.getEmail();
        this.password = dto.getPassword();
    }
}
