package excepciones;

import modelo.Paciente;

public class PacienteNoEncontradoExcepcion extends Exception {
    String dni;
    @SuppressWarnings("oracle.jdeveloper.java.insufficient-catch-block")
    public PacienteNoEncontradoExcepcion(String dni)
    {   
        super();
        this.dni= dni;
    }

    public String getDato() {
        return dni;
    }
}
