package com.mustafa.employeemanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExcetion extends RuntimeException{
    public ResourceNotFoundExcetion(String message){
        super(message);
    }
}
