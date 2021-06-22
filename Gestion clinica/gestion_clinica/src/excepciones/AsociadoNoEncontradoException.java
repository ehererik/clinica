package excepciones;

public class AsociadoNoEncontradoException extends Exception
{
	String dni;
    @SuppressWarnings("oracle.jdeveloper.java.insufficient-catch-block")
    public AsociadoNoEncontradoException(String message,String dni)
    {   
        super(message);
        this.dni= dni;
    }

    public String getDato() {
        return dni;
    }
}
