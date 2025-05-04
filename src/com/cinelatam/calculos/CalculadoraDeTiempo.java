package com.cinelatam.calculos;
import com.cinelatam.modelos.Pelicula;
import com.cinelatam.modelos.Serie;
import com.cinelatam.modelos.Titulo;

public class CalculadoraDeTiempo {
    private int tiempoTotal;

    public int getTiempoTotal() {
        return tiempoTotal;
    }

    public void incluye(Titulo titulo) {

        this.tiempoTotal += titulo.getDuracionEnMinutos();
    }

}
