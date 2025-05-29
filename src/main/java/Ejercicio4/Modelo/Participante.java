package Ejercicio4.Modelo;

public class Participante {
    private String nombre;
    private String telefono;
    private String region;

    public Participante(String nombre, String telefono,String region) {
        validarParticipante(nombre,telefono,region);
        this.nombre = nombre;
        this.telefono=telefono;
        this.region=region;
    }

    public String nombre(){
        return nombre;
    }
    public String telefono(){
        return telefono;
    }
    public String region(){
        return region;
    }

    private void validarParticipante(String nombre, String telefono,String region) {
        if (nombre.isEmpty()) {
            throw new IllegalArgumentException("Debe cargar un nombre");
        }
        if (telefono.isEmpty()) {
            throw new IllegalArgumentException("Debe cargar un teléfono");
        }
        if (!validarTelefono(telefono)) {
            throw new IllegalArgumentException("El teléfono debe ser NNNN-NNNNNN");
        }
        if (!region.equals("China") &&
                !region.equals("US") &&
                !region.equals("Europa")) {
            throw new IllegalArgumentException("Región desconocida. Las conocidas son: China, US, Europa");
        }
    }
    private boolean validarTelefono(String telefono) {
        String regex = "\\d{4}-\\d{6}";
        return telefono.matches(regex);
    }

}