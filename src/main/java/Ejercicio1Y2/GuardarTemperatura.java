package Ejercicio1Y2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;

public class GuardarTemperatura implements Observador {
    private static final String RUTA="C:\\Users\\santi\\OneDrive\\Escritorio\\java\\Temperaturas.txt";

    @Override
    public void update(double temperatura) {
        String registro= temperatura + "||" + LocalDate.now();
        try {
            Files.write((Paths.get(this.RUTA)),
                    registro.getBytes(),
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo persistir", e);
        }
    }
}
