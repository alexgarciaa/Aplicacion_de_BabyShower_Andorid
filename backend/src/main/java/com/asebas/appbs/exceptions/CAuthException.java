package com.asebas.appbs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class CAuthException extends RuntimeException {

    public CAuthException(String message) {
        super(message);
    }

}
