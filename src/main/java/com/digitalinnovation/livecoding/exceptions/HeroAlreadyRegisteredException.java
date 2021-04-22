package com.digitalinnovation.livecoding.exceptions;

import jdk.javadoc.internal.doclets.formats.html.PackageUseWriter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class HeroAlreadyRegisteredException extends Exception{

    public HeroAlreadyRegisteredException(String id){
        super(String.format("Hero with id %s already registred in the system", id));
    }
}
