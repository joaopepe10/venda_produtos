package com.consumidor.projetosite.util;

public class CPFValidator {

    public String validateCpf(String cpf){
        if (validateSize(cpf)){
            return characterRemove(cpf);
        }
        return "CPF INVALIDO!";
    }
    private String characterRemove(String cpf){
        return cpf.replaceAll("[.\\-]", "");
    }

    public boolean validateSize(String cpf){
        cpf = characterRemove(cpf);
        return cpf.length() == 11;
    }
}
