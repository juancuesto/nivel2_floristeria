package com.floristeria_sql.nivel_floristeria.Exception;

import org.springframework.http.HttpStatus;

public class BadRequest extends RuntimeException{
    private String code;
    private HttpStatus status;

    public BadRequest(String code, HttpStatus status,String message) {
        super(message);
        this.code = code;
        this.status = status;
    }
}
