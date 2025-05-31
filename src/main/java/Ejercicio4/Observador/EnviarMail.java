package Ejercicio4.Observador;

import Ejercicio4.Modelo.IMail;
import Ejercicio4.Modelo.Participante;

public class EnviarMail implements Observadores{
    private IMail serviceMail;

    public EnviarMail(IMail serviceMail) {
        this.serviceMail = serviceMail;
    }

    @Override
    public void notificar(Participante participante) {
        serviceMail.enviarCorreo("santiagoabdala270@gmail.com",
                "Inscripcion","Se ha inscripto correctamente");
    }
}
