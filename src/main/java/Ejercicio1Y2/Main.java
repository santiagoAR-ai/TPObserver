package Ejercicio1Y2;

public class Main {
    public static void main(String[] args) {
        var sitioWeb= new WeatherChannelService();
        var clima=new Medidor(sitioWeb);
        var guardar= new GuardarTemperatura();
        var aviso= new AvisoTemperatura();
        clima.AgregarObservador(guardar);
        clima.AgregarObservador(aviso);
        System.out.println(clima.leerTemperatura());
    }
}
