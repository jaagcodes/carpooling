package com.reto.carpooling.exception;

public class UserAlreadyExistsException extends RuntimeException{

    private static final String message = "Ya existe un usuario con ese correo";

    public UserAlreadyExistsException(){
        super(message);
    }
}
