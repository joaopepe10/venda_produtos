package com.consumidor.projetosite.services;

import com.consumidor.projetosite.repositories.UserRepository;
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
}
