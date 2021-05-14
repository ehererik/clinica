package modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Factura
{

	private int numFactura = 0;
	GregorianCalendar fecha;
	Paciente paciente;
	ArrayList<Prestacion> prestaciones = new ArrayList<>();

	public Factura(GregorianCalendar fecha, Paciente paciente, ArrayList<Prestacion> prestaciones)
	{
		this.fecha = fecha;
		this.paciente = paciente;
		this.prestaciones = prestaciones;
		this.numFactura++;
	}

	public ArrayList<Prestacion> getPrestaciones()
	{
		return prestaciones;
	}

	public void setPrestaciones(ArrayList<Prestacion> prestaciones)
	{
		this.prestaciones = prestaciones;
	}

	public int getNumFactura()
	{
		return numFactura;
	}

	public Calendar getFecha()
	{
		return fecha;
	}

	public Paciente getPaciente()
	{
		return paciente;
	}

	public void muestraPrestacionMedico(IMedico medico, Double subTotal)
	{ // subTotal tiene que pasar por referencia
		int i = 0;
		int n = this.prestaciones.size();

		String nombreMedico = medico.getClavePrimaria();
		while (i < n && !(this.prestaciones.get(i).getClavePrimaria().equals(nombreMedico)))
			i++;

		if (i < n)
		{ // el medico atendio al paciente
			subTotal = this.prestaciones.get(i).getSubTotal();
			System.out.println(
					this.paciente.getNombre() + "      $" + this.prestaciones.get(i).getValorUnitarioPrestacion() * 0.8 + "         "
							+ this.fecha + "        " + this.prestaciones.get(i).getCantidad() + "       $" + subTotal);
		}
	}

	@Override
	public String toString()
	{ 
		return "Numero de factura: " + this.numFactura + "\nFecha: " + this.fecha + "\nPaciente: "
				+ this.paciente.getNombre() + "\n---------- Listado de prestaciones --------\n"
				+ this.prestaciones.toString();
	}
	
	public String toStringPrestaciones() {
		StringBuilder sb = new StringBuilder();
		java.util.Iterator<Prestacion> it = this.prestaciones.iterator();
		while(it.hasNext()) {
			sb.append(it.next().toString());
			sb.append("\n");
		}
		return sb.toString();
	}
	
}
