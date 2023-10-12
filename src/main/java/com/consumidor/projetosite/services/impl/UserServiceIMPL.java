package com.consumidor.projetosite.services.impl;

import com.consumidor.projetosite.dto.request.user.UserRequest;
import com.consumidor.projetosite.exception.BusnissesRulesException;
import com.consumidor.projetosite.models.User;
import com.consumidor.projetosite.models.attributes.Adress;
import com.consumidor.projetosite.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceIMPL {
    @Autowired
    private UserRepository userRepository;

    public User findById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new BusnissesRulesException("Codigo de cliente invalido!"));
    }
    public User save(UserRequest dto) {
        User user = new User(dto);
        return userRepository.save(user);
    }

    public Adress updadeAdress(Long id, Adress adress) {
        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new BusnissesRulesException("Codigo de cliente invalido!"));
        userRepository.save(user);
        return adress;
    }
}
