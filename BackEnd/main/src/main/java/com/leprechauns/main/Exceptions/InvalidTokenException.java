package com.leprechauns.main.Exceptions;

public class InvalidTokenException extends RuntimeException{
    
    public InvalidTokenException(String message){
        super(message);
    }
}
