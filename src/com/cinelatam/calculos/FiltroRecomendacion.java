package com.cinelatam.calculos;

public class FiltroRecomendacion {

    public void filtra(Clasificable clasificable) {
        if (clasificable.getClasificable() >= 4) {
            System.out.println("En el top 10 de hoy");
        } else if (clasificable.getClasificable() >= 2) {
            System.out.println("Recomendado para ti");
        } else {
            System.out.println("Para ver después");
        }
    }
}
