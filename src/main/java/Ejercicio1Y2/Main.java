package Ejercicio1Y2;

public class Main {
    public static void main(String[] args) {
        var sitioWeb= new WeatherChannelService();
        var clima=new Medidor(sitioWeb);
        var guardar= new GuardarTemperatura();
        var aviso= new AvisoTemperatura();
        clima.agregarObservador(guardar);
        clima.agregarObservador(aviso);
        System.out.println(clima.leerTemperatura());
    }
}
