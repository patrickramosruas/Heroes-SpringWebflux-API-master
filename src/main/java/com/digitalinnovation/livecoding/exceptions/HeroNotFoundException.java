package com.digitalinnovation.livecoding.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class HeroNotFoundException extends Exception {
    public HeroNotFoundException(String id){
        super(String.format("Hero with id %s not found in the system",id));
    }
}
