package Ejercicio4.Observador;

import Ejercicio4.Modelo.Participante;

import java.util.ArrayList;
import java.util.List;

public class Sujetos {
    private List<Observadores> listaObservadores= new ArrayList<>();
    public void agregarObservador(Observadores observador) {
        listaObservadores.add(observador);
    }

    protected void notificarObservadores(Participante participante) {
        for (Observadores observadores : listaObservadores) {
            observadores.notificar(participante);
        }
    }
}
