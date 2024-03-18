package com.leprechauns.main.Exceptions;

public class NotFoundEndPoint extends RuntimeException {
    
    public NotFoundEndPoint(String message){
        super(message);
    }
}
