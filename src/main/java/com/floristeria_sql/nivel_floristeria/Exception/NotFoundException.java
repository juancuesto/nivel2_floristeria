package com.floristeria_sql.nivel_floristeria.Exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends RuntimeException{
    private String code;
    private HttpStatus status;
    public NotFoundException(String code, HttpStatus status, String message) {
        super(message);
        this.code=code;
        this.status=status;
    }
}
