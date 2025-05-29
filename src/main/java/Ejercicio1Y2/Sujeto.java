package Ejercicio1Y2;

import java.util.ArrayList;
import java.util.List;

public class Sujeto {
    private List<Observador> listaObservadores= new ArrayList<>();
    public void agregarObservador(Observador observador) {
        listaObservadores.add(observador);
    }

    public void eliminarObservador(Observador observador) {
        listaObservadores.remove(observador);
    }

    protected void notificarObservadores(double temperatura) {
        for (Observador observador : listaObservadores) {
            observador.update(temperatura);
        }
    }
}
