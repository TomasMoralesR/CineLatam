package com.cinelatam.servicios;

import com.cinelatam.excepcion.DuracionConversionErrorException;
import com.cinelatam.modelos.Titulo;
import com.cinelatam.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ConversorDeTitulo {
    private Gson gson;

    public ConversorDeTitulo() {
        gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
    }

    public Titulo convertirDesdeJson(String json) throws DuracionConversionErrorException {
        TituloOmdb tituloOmdb = gson.fromJson(json, TituloOmdb.class);
        return new Titulo(tituloOmdb);
    }

    public String convertirListaATexto(Object objeto) {
        return gson.toJson(objeto);
    }
}
