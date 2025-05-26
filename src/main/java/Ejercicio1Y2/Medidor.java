package Ejercicio1Y2;

import java.util.ArrayList;
import java.util.List;

public class Medidor {
    private String temperatura;
    private ClimaOnline clima;
    private List<Observador> listaObservadores= new ArrayList<>();

    public Medidor(ClimaOnline clima) {
        this.clima = clima;
    }

    public void AgregarObservador(Observador observador){
        listaObservadores.add(observador);
    }

    public String leerTemperatura() {
        this.temperatura = this.clima.temperatura();
        for(Observador observador: listaObservadores){
            observador.update(this.clima.obtenerTemperatura());
        }
        return this.temperatura;
    }
}
