package com.consumidor.projetosite.controllers.v1;

import com.consumidor.projetosite.exception.BusnissesRulesException;
import com.consumidor.projetosite.util.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {
    @ExceptionHandler(BusnissesRulesException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleBusnissesRulesException(BusnissesRulesException ex){
        String messageError = ex.getMessage();
        return new ApiErrors(messageError);
    }
}
