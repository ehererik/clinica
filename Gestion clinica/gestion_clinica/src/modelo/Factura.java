package modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Factura
{

	private static int cantFacturas = 0;
	private int numFactura;
	GregorianCalendar fecha;
	Paciente paciente;
	ArrayList<Prestacion> prestaciones = new ArrayList<>();

	public Factura(GregorianCalendar fecha, Paciente paciente, ArrayList<Prestacion> prestaciones)
	{
		this.fecha = fecha;
		this.paciente = paciente;
		this.prestaciones = prestaciones;
		Factura.cantFacturas++;
		this.numFactura = Factura.cantFacturas;
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
			System.out.println(this.paciente.getNombre() + "      $"
					+ this.prestaciones.get(i).getValorUnitarioPrestacion() * 0.8 + "         " + this.fecha
					+ "        " + this.prestaciones.get(i).getCantidad() + "       $" + subTotal);
		}
	}


	public void muestraFactura()
	{
		System.out.println("Numero de factura: " + this.numFactura + "\nFecha: " + this.fecha + "\nPaciente: "
				+ this.paciente.getNombre() + "\n---------- Listado de prestaciones --------\n"
				+ "       Prestacion              Valor           Cantidad               Subtotal    ");
		for (int i = 0; i < this.prestaciones.size(); i++)
		{
			this.prestaciones.get(i).mostrarPrestacion();
		}

	}

	public String toStringPrestaciones()
	{
		StringBuilder sb = new StringBuilder();
		java.util.Iterator<Prestacion> it = this.prestaciones.iterator();
		while (it.hasNext())
		{
			sb.append(it.next().toString());
			sb.append("\n");
		}
		return sb.toString();
	}

	public double totalFactura()
	{

		double total = 0;
		for (int i = 0; i < this.prestaciones.size(); i++)
		{
			total += this.prestaciones.get(i).getSubTotal();
		}
		return total;
	}

}
