package com.cinelatam.modelos;

import com.cinelatam.calculos.Clasificable;

public class Pelicula extends Titulo implements Clasificable {
    private String director;

    public Pelicula(String nombre, int fechaDeLanzamiento) {
        super(nombre, fechaDeLanzamiento);
    }

    //Getter y setter
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int getClasificable() {
        return (int) calculaMedia() / 2;
    }

    @Override
    public String toString() {
        return "Película: " + this.getNombre() + " (" + getFechaDeLanzamiento() +") ";
    }
}
