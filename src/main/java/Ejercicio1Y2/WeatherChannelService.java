package Ejercicio1Y2;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherChannelService implements ClimaOnline {
    String url = "https://api.openweathermap.org/data/2.5/weather?q=Viedma,Argentina&units=metric&APPID=6baa3c168daa7b0227dfa4ba72c9cc15";
    @Override
    public double obtenerTemperatura(){
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request= HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();
            HttpResponse<String> response= client.send(request,HttpResponse.BodyHandlers.ofString());
            JSONObject obj = new JSONObject(response.body());
            double temp = obj.getJSONObject("main").getDouble("temp");

            return temp;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public String temperatura() {
        return obtenerTemperatura() +"° Celcius";
    }
}
