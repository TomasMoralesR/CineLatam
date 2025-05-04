package com.cinelatam.excepcion;

public class DuracionConversionErrorException extends RuntimeException {
    private String mensaje;

    public DuracionConversionErrorException(String mensaje) {
    this.mensaje = mensaje;
    }

    @Override
    public String getMessage() {
        return this.mensaje;
    }
}
