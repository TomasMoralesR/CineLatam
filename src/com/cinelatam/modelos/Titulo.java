package com.cinelatam.modelos;

import com.cinelatam.excepcion.DuracionConversionErrorException;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable <Titulo>{
    private String nombre;
    private int fechaDeLanzamiento;
    private int duracionEnMinutos;
    private boolean incluidoEnElPlan;
    private double sumaDeEvaluaciones;
    private int totalEvaluaciones;

    //Constructor con nombre y fecha de lanzamiento
    public Titulo(String nombre, int fechaDeLanzamiento) {
        this.nombre = nombre;
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public Titulo(TituloOmdb tituloOmdb) {
        this.nombre = tituloOmdb.title();
        this.fechaDeLanzamiento = Integer.valueOf(tituloOmdb.year());
        if (tituloOmdb.runtime().contains("N/A")) {
            throw new DuracionConversionErrorException("No hay información de la duración");
        }
        this.duracionEnMinutos = Integer.valueOf(tituloOmdb.runtime().substring(0,3).replace(" ", ""));
    }

    //Getters
    public String getNombre() {
        return nombre;
    }

    public int getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    public boolean isIncluidoEnElPlan() {
        return incluidoEnElPlan;
    }

    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaDeLanzamiento(int fechaDeLanzamiento) {
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public void setDuracionEnMinutos(int duracionEnMinutos) {
        this.duracionEnMinutos = duracionEnMinutos;
    }

    public void setIncluidoEnElPlan(boolean incluidoEnElPlan) {
        this.incluidoEnElPlan = incluidoEnElPlan;
    }

    //Métodos
    public int getTotalEvaluaciones(){
        return totalEvaluaciones;
    }

    public void muestraFichaTecnica() {
        System.out.println("El nombre de la película es: " + nombre);
        System.out.println("Fecha de lanzamiento: " + fechaDeLanzamiento);
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
    }

    public void evalua(double nota) {
        sumaDeEvaluaciones += nota;
        totalEvaluaciones++;
    }

    public double calculaMedia(){

        return sumaDeEvaluaciones / totalEvaluaciones;
    }

    @Override
    public int compareTo(Titulo otroTitulo) {
        return this.getNombre().compareTo(otroTitulo.getNombre());
    }

    @Override
    public String toString() {
        return "(nombre=" + nombre +
                ", fechaDeLanzamiento=" + fechaDeLanzamiento
                + ", duración=" + duracionEnMinutos+")";
    }
}
