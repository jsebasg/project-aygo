package com.co.escuealing.mapsito.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class GoogleMapsDirectionsAPI {

    // Método para obtener el tiempo de demora entre puntos
    public String obtenerTiempoDemora(String origen, String destino, String[] paradas, String apiKey) {
        try {
            // Construir la URL para la API de Google Maps Directions
            StringBuilder urlBuilder = new StringBuilder();
            urlBuilder.append("https://maps.googleapis.com/maps/api/directions/json?origin=")
                 .append(origen)
                 .append("&destination=")
                 .append(destino);

            // Si hay paradas intermedias, agregar las waypoints
            if (paradas != null && paradas.length > 0) {
                urlBuilder.append("&waypoints=optimize:true|");
                for (String parada : paradas) {
                    urlBuilder.append(parada).append("|");
                }
                // Eliminar el último "|" que se agrega de más
                urlBuilder.deleteCharAt(urlBuilder.length() - 1);
            }

            // Agregar la API key
            urlBuilder.append("&key=").append(apiKey);

            // Realizar la solicitud HTTP
            URL url = new URL(urlBuilder.toString());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Parsear la respuesta JSON
            JSONObject responseObject = new JSONObject(response.toString());
            if (responseObject.getString("status").equals("OK")) {
                // Obtener el tiempo total de la ruta
                JSONArray routes = responseObject.getJSONArray("routes");
                JSONObject route = routes.getJSONObject(0);
                JSONObject legs = route.getJSONArray("legs").getJSONObject(0);
                JSONObject duration = legs.getJSONObject("duration");
                return duration.getString("text"); // Devuelve el tiempo estimado de duración
            } else {
                return "Error en la solicitud: " + responseObject.getString("status");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al procesar la solicitud";
        }
    }
}

