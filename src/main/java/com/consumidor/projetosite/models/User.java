package com.consumidor.projetosite.models;

import com.consumidor.projetosite.dto.request.UserRequest;
import com.consumidor.projetosite.models.attributes.Adress;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

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

    private String name;

    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private Short day;

    @Column()
    private Short month;

    @Column()
    private Short year;

    @Embedded
    private Adress adress;

    public User(UserRequest dto){
        this.name = dto.getName();
        this.lastName = dto.getLastName();
        this.day = dto.getDay();
        this.month = dto.getMonth();
        this.year = dto.getYear();
        this.email = dto.getEmail();
        this.password = dto.getPassword();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(getId(), user.getId()) && Objects.equals(getName(), user.getName()) && Objects.equals(getLastName(), user.getLastName()) && Objects.equals(getEmail(), user.getEmail()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getDay(), user.getDay()) && Objects.equals(getMonth(), user.getMonth()) && Objects.equals(getYear(), user.getYear()) && Objects.equals(getAdress(), user.getAdress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEmail());
    }
}
