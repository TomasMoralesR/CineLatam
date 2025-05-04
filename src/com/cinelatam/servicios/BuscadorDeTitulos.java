package com.cinelatam.servicios;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class BuscadorDeTitulos {
    private static final String API_KEY = "a6606462";

    public String buscar(String titulo) throws Exception {
        String busquedaCodificada = URLEncoder.encode(titulo, StandardCharsets.UTF_8);
        String direccion = "https://www.omdbapi.com/?t=" + busquedaCodificada + "&apikey=" + API_KEY;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
