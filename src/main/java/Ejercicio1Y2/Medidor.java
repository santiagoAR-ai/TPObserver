package Ejercicio1Y2;

public class Medidor extends Sujeto {
    private String temperatura;
    private ClimaOnline clima;

    public Medidor(ClimaOnline clima) {
        this.clima = clima;
    }

    public String leerTemperatura() {
        this.temperatura = this.clima.temperatura();
        notificarObservadores(this.clima.obtenerTemperatura());
        return this.temperatura;
    }
}
