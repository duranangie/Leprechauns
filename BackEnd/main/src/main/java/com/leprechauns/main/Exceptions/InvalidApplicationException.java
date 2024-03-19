package com.leprechauns.main.Exceptions;

public class InvalidApplicationException extends RuntimeException {
    
    public InvalidApplicationException(String message){
        super(message);
    }
}
