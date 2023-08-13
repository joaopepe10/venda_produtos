package com.consumidor.projetosite.models;

import com.consumidor.projetosite.dto.request.UserRequest;
import com.consumidor.projetosite.models.attributes.Adress;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_users")
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 14)
    @CPF()
    private String cpf;

    @Column(name = "name",length = 100)
    private String name;

    @Column(length = 100)
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(getId(), user.getId()) && Objects.equals(getCpf(), user.getCpf()) && Objects.equals(getName(), user.getName()) && Objects.equals(getLastName(), user.getLastName()) && Objects.equals(getEmail(), user.getEmail()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getBirthDay(), user.getBirthDay()) && Objects.equals(getBirthMonth(), user.getBirthMonth()) && Objects.equals(getBirthYear(), user.getBirthYear()) && Objects.equals(getAdress(), user.getAdress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
