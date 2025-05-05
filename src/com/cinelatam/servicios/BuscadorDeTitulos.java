package com.cinelatam.servicios;

import com.cinelatam.excepcion.UnableToLoadApiKey;
import io.github.cdimascio.dotenv.Dotenv;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class BuscadorDeTitulos {
    private static final String API_KEY = loadApiKey();

    private static String loadApiKey() {
        try {
            Dotenv dotenv = Dotenv.load();
            String apiKey = dotenv.get("API_KEY");

            if (apiKey == null || apiKey.isBlank()) {
                throw new UnableToLoadApiKey("API_KEY not found in .env file");
            }

            return apiKey;
        } catch (Exception e) {
            throw new UnableToLoadApiKey("Error loading the .env file or reading the API_KEY", e);
        }
    }

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
