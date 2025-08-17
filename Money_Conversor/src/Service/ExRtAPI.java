package Service;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

    public class ExRtAPI {
        @SerializedName("base_code")
        private String baseCode;
        @SerializedName("target_code")
        private String targetCode;
        @SerializedName("conversion_rate")
        private double conversionRate;

        // Métodos getter públicos
        public String base_code() {
            return baseCode;
        }

        public String target_code() {
            return targetCode;
        }

        public double conversion_rate() {
            return conversionRate;
        }


        public static String construirURL(String monedaBase, String monedaNew) {
            return "https://v6.exchangerate-api.com/v6/f7c11aa90887c6c18210a5ae/pair/"
                    + monedaBase + "/" + monedaNew;
        }

        public static String consultarURL(String url) {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            try {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                return response.body();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        }

        public static ExRtAPI parseRate(String respuestaExchange) {
            if (respuestaExchange == null || respuestaExchange.isEmpty()) {
                System.out.println("Error: Respuesta vacía o nula de la API.");
                return null;
            }
            try {
                Gson gson = new Gson();
                return gson.fromJson(respuestaExchange, ExRtAPI.class);
            } catch (JsonSyntaxException e) {
                System.out.println("Error al parsear la respuesta JSON: " + e.getMessage());
                return null;
            }
        }
    }