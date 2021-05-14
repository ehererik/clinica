package modelo;

public class Ninio extends Paciente {
    public Ninio() {
        super();
    }

    protected Ninio(String nombre, String apellido, String dni, String domicilo, String ciudad, String telefono) {
        super(nombre, apellido, dni, domicilo, ciudad, telefono);
    }


    @Override
    public boolean establecerPriotodad(Paciente p) {
        if(p==null)
            return true;
        else
            return p.ninioPregunta();
    }

    @Override
    public boolean ninioPregunta() {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean jovenPregunta() {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean mayorPregunta() {
        // TODO Implement this method
        return true;
    }
}
