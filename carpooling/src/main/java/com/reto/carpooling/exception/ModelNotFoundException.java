package com.reto.carpooling.exception;

public class ModelNotFoundException extends RuntimeException{

    private String message;

    public ModelNotFoundException(String message){
        super(message);
    }
}
