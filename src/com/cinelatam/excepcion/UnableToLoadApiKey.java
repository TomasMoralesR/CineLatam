package com.cinelatam.excepcion;

public class UnableToLoadApiKey extends RuntimeException{
    public UnableToLoadApiKey(String message) {
        super(message);
    }

    public UnableToLoadApiKey(String message, Throwable cause) {
        super(message, cause);
    }
}
