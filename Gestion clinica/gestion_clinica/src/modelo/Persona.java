package modelo;

public abstract class Persona {
    String nombre;
    String apellido;
    String dni;
    String domicilo;
    String ciudad;
    String telefono;


    public Persona(String nombre, String apellido, String dni, String domicilo, String ciudad, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.domicilo = domicilo;
        this.ciudad = ciudad;
        this.telefono = telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDomicilo(String domicilo) {
        this.domicilo = domicilo;
    }

    public String getDomicilo() {
        return domicilo;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }
}
