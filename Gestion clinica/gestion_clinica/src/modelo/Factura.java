package modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Factura {

	private static int cantFacturas = 0;
	private int numFactura;
	GregorianCalendar fecha;
	Paciente paciente;
	ArrayList<Prestacion> prestaciones = new ArrayList<>();

	public Factura(GregorianCalendar fecha, Paciente paciente, ArrayList<Prestacion> prestaciones) {
		this.fecha = fecha;
		this.paciente = paciente;
		this.prestaciones = prestaciones;
		Factura.cantFacturas++;
		this.numFactura = Factura.cantFacturas;
	}

	public ArrayList<Prestacion> getPrestaciones() {
		return prestaciones;
	}

	public void setPrestaciones(ArrayList<Prestacion> prestaciones) {
		this.prestaciones = prestaciones;
	}

	public int getNumFactura() {
		return numFactura;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	
	
	
	/**Muestra todas las prestacion de un medico de una factura determinada<br>.
	 * @param medico
	 * @return 
	 */
	public double muestraPrestacionMedico(IMedico medico)
	{ // subTotal tiene que pasar por referencia
		int i = 0;
		int n = this.prestaciones.size();
		double subTotal,totalFactura=0;
		String nombreMedico = medico.getClavePrimariaString(); //tambien podria ser medico.getNombre();
		
		while (i < n) {

			if ( this.prestaciones.get(i).getClavePrimariaString().equals(nombreMedico) )   // el medico atendio al paciente
			{ 
				subTotal = this.prestaciones.get(i).getSubTotal();
				totalFactura+=subTotal; 
				System.out.printf("%22s %17.2f %25d   %35s              $ %8.2f %n",this.paciente.getNombre(),
						this.prestaciones.get(i).getValorUnitarioPrestacion() * 0.8,this.prestaciones.get(i).getCantidad()
						,this.muestraFecha(),subTotal);
			}
			
			i++;
		}
		return totalFactura;
	}

	
	
	
	
	public void muestraFactura() {
		System.out.println("Numero de factura: " + this.numFactura + "\nFecha: " + this.muestraFecha() + "\nPaciente: "
				+ this.paciente.getNombre()
				+ "\n\n------------------------------------------ Listado de prestaciones ----------------------------------\n"
				+ "       Prestacion              Valor           Cantidad               Subtotal    ");
		for (int i = 0; i < this.prestaciones.size(); i++) {
			this.prestaciones.get(i).mostrarPrestacion();
		}

	}

	
	public String muestraFecha() {
		return this.fecha.get(Calendar.DATE) + "/" + this.fecha.get(Calendar.MONTH) + "/"
				+ this.fecha.get(Calendar.YEAR);
	}

	
	public double totalFactura() {

		double total = 0;
		for (int i = 0; i < this.prestaciones.size(); i++) {
			total += this.prestaciones.get(i).getSubTotal();
		}
		return total;
	}

}
