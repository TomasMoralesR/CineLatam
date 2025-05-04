package com.cinelatam.principal;

import com.cinelatam.excepcion.DuracionConversionErrorException;
import com.cinelatam.modelos.Titulo;
import com.cinelatam.servicios.BuscadorDeTitulos;
import com.cinelatam.servicios.ConversorDeTitulo;
import com.cinelatam.servicios.GestorDeTitulos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalConBusqueda {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Titulo> titulos = new ArrayList<>();
        BuscadorDeTitulos buscador = new BuscadorDeTitulos();
        ConversorDeTitulo conversor = new ConversorDeTitulo();
        GestorDeTitulos gestor = new GestorDeTitulos(conversor);

        while (true) {
            System.out.println("Escriba el nombre del título: ");
            String busqueda = scanner.nextLine();

            if (busqueda.equalsIgnoreCase("salir")) {
                break;
            }

            try {
                String json = buscador.buscar(busqueda);
                System.out.println(json);

                Titulo titulo = conversor.convertirDesdeJson(json);
                System.out.println("Título convertido: " + titulo);
                titulos.add(titulo);
            } catch (NumberFormatException e) {
                System.out.println("Error de formato numérico: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Error en la URI. Verifique la dirección.");
            } catch (DuracionConversionErrorException e) {
                System.out.println("Error al convertir duración: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
        }

        try {
            gestor.guardarEnArchivo(titulos, "titulos.json");
            System.out.println("Títulos guardados exitosamente.");
        } catch (Exception e) {
            System.out.println("No se pudo guardar el archivo: " + e.getMessage());
        }

        System.out.println("Finalizó la ejecución del programa");
    }
}
