package com.codewa.spring_validation.haldler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArguments
            (MethodArgumentNotValidException ex) {
        Map<String , String> map = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach((error) -> {
            map.put(error.getField(), error.getDefaultMessage());
        });
        return map;
    }
}
