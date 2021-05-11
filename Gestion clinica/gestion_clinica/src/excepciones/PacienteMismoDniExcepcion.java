package excepciones;

import modelo.Paciente;

public class PacienteMismoDniExcepcion extends Exception {
    String dni;
    @SuppressWarnings("oracle.jdeveloper.java.insufficient-catch-block")
    public PacienteMismoDniExcepcion(String dni) {
        super();
            this.dni=dni;
    }

    public String getDni() {
        return dni;
    }
}
