package com.melikeyalpi.question5.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BasicException.class)
    public String handleBasicException(BasicException basicException){
        return basicException.getMessage();
    }

}
