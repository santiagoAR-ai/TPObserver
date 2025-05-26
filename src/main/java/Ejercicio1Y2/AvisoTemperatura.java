package Ejercicio1Y2;

public class AvisoTemperatura implements Observador {
    @Override
    public void update(double temperatura) {
        if(temperatura>17){
            System.out.println("Hace calor, se encenderá el aire acondicionado");
        }
        if(temperatura<12){
            System.out.println("Hace frio, se encenderá la caldera");
        }
    }
}
