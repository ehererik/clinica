package modelo;


public abstract class Paciente extends Persona implements PrioridadAsignacion
{
	int nroOrden;

	public Paciente(String nombre, String apellido, String dni, String domicilo, String ciudad, String telefono)
	{
		super(nombre, apellido, dni, domicilo, ciudad, telefono);
	}

	public Paciente()
	{
		super();
	}
	
	public void setNroOrden(int nroOrden)
	{
		this.nroOrden = nroOrden;
	}

	public int getNroOrden()
	{
		return nroOrden;
	}
}