package com.devsu.movimientos_services.application.exception;

public class ClienteNoExisteException extends RuntimeException {
    
    public ClienteNoExisteException(String message) {
        super(message);
    }
    
}
