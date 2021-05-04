package modelo;

public class Paciente extends Persona {
    char rangoEt;

    public Paciente(String nombre, String apellido, String dni, String domicilo, String ciudad, String telefono, char re) {
        super(nombre, apellido, dni, domicilo, ciudad, telefono);
        this.rangoEt=re;
    }
}
