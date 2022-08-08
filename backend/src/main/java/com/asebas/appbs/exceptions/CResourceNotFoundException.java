package com.asebas.appbs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CResourceNotFoundException extends RuntimeException {

    public CResourceNotFoundException(String message) {
        super(message);
    }
    
}
