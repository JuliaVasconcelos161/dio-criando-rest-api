package com.github.juliavasconceloscr161.diocriandorestapi.handler;

public class RequiredField extends BusinessException{
    public RequiredField(String field) {
        super("O campo %s é obrigatório", field);
    }
}
