package com.asebas.appbs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CBadRequestException extends RuntimeException {

    public CBadRequestException(String message) {
        super(message);
    }

}
