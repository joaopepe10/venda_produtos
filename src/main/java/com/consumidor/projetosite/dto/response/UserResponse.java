package com.consumidor.projetosite.dto.response;

import com.consumidor.projetosite.dto.request.user.UserRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private String name;
    private String lastName;

    public UserResponse(UserRequest request){
        this.name = request.getName();
        this.lastName = request.getLastName();
    }
}
