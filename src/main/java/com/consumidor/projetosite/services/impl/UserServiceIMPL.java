package com.consumidor.projetosite.services.impl;

import com.consumidor.projetosite.dto.request.UserRequest;
import com.consumidor.projetosite.models.User;
import com.consumidor.projetosite.repositories.UserRepository;
import com.consumidor.projetosite.util.CPFValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceIMPL {
    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(userRepository.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<?> findById(Long id){
        return new ResponseEntity<>(userRepository.findById(id),HttpStatus.OK);
    }
    public String save(UserRequest dto) {
        CPFValidator validator = new CPFValidator();
        if (validator.validateSize(dto.getCpf())){
            dto.setCpf(validator.validateCpf(dto.getCpf()));
            User user = new User(dto);
            userRepository.save(user);
            return "Salvo com sucesso!";
        }
        return "Nao foi possivel salvar os dado!";
    }
}
