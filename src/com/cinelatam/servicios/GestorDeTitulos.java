package com.cinelatam.servicios;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GestorDeTitulos {
    private ConversorDeTitulo conversor;

    public GestorDeTitulos(ConversorDeTitulo conversor) {
        this.conversor = conversor;
    }

    public void guardarEnArchivo(List<?> lista, String nombreArchivo) throws IOException {
        FileWriter fw = new FileWriter(nombreArchivo);
        fw.write(conversor.convertirListaATexto(lista));
        fw.close();
    }
}
