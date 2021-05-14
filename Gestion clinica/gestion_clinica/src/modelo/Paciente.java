package modelo;

import java.util.ArrayList;

public abstract class Paciente extends Persona implements PrioridadAsignacion
{
	int nroOrden;
	ArrayList<Prestacion> prestaciones = new ArrayList<Prestacion>();

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
	
	public void agregarPrestacion(Prestacion prestacion) {
		prestaciones.add(prestacion);		
	}

	public ArrayList<Prestacion> getPrestaciones()
	{
		return prestaciones;
	}
	
}