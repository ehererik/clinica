package modelo;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import excepciones.PacienteInvalidoException;
import modulos.Atencion;
import modulos.Datos;
import modulos.Ingreso;
import modulos.Recepcion;

public class Clinica
{
	private String nombre;
	private Datos datos = new Datos();
	private Recepcion recepcion = new Recepcion();
	private Ingreso ingreso = new Ingreso();
	private Atencion atencion = new Atencion();
	ArrayList<Factura> facturas = new ArrayList<>();

	public Clinica()
	{
		super();
	}

	public void altaPaciente(Paciente p)
	{
		this.recepcion.peticionAlta(this.datos, p);
	}

	public Paciente consultaPaciente(String dni)
	{
		return this.recepcion.peticionConsulta(this.datos, dni);
	}

	public void bajaPaciente(String dni)
	{
		this.recepcion.peticionBaja(this.datos, dni);
	}

	public void modNyA(String dni, String nom, String ape)
	{
		this.recepcion.peticionModNyA(this.datos, dni, nom, ape);
	}

	public void modDom(String dni, String dom)
	{
		this.recepcion.peticionModDom(this.datos, dni, dom);
	}

	public void modTel(String dni, String tel)
	{
		this.recepcion.peticionModTel(this.datos, dni, tel);
	}

	public void ingresarPaciente(Paciente p)
	{
		this.recepcion.ingresarPaciente(p, this.ingreso);
	}

	public void atenderProxPaciente()
	{
		this.ingreso.atenderPaciente(this.atencion);
	}

	public void muestraPacienteSalaPriv()
	{
		this.ingreso.muestraPacSalaPriv();
	}

	public void muestraPacientesPatio()
	{
		this.ingreso.muestraPacPatio();
	}

	public void muestraPacientesEnAtencion()
	{
		this.atencion.muestraPacientes();
	}

///////////////////////////// MODULO DE EGRESO Y FACTURACION /////////////////////////////////////////////////////////////	
	public void darAltaYFacturar(Paciente paciente, ArrayList<Paciente> pacientes) throws PacienteInvalidoException
	{

		// ArrayList<Prestacion> prestaciones = new ArrayList<>(); no va, lo recibo por
		// paramtero

		int i = 0;
		int n = pacientes.size();

		if (i < n && !(pacientes.get(i).equals(paciente))) // busca el paciente recibo
			i++;

		if (i == n)
		{
			throw new PacienteInvalidoException("El paciente que desea dar del alta no se encuentra en la clinica",
					paciente); // pasa la excepcion a erik
		}

		GregorianCalendar fecha = new GregorianCalendar();
		// poner el avance de tiempo
		facturas.add(new Factura(fecha, paciente, paciente.getPrestaciones)); // Crea la factura del paciente

		System.out.println("       Prestacion              Valor           Cantidad               Subtotal    ");

		System.out.println(facturas.get(facturas.size() - 1).toString()); // Muestra factura del paciente que se ira de
																			// la clinica
		pacientes.remove(i); // saco al paciente de la clinica
	}

///////////////////////////// REPORTE DE ACTIVIDAD MEDICA /////////////////////////////////////////////////////////////		

	public void reporteActividadMedica(Medico medico, GregorianCalendar desde, GregorianCalendar hasta)
	{

		int i = 0;
		int n = facturas.size();
		double total = 0;
		Double subTotal;

		while (i < n && facturas.get(i).getFecha().compareTo(desde) < 0)// BUSCO EN EL ARRAY DE FACTURAS HASTA ENCONTRAR
																		// LA FECHA "desde" o una mayor
			i++;

		if (i < n)
		{ // Encontre una fecha perteneciente al intervalo
			System.out.println("\nConsultas atendidas por el medico/a " + medico.getNombre());
			System.out.println(
					"    NOMBRE DEL PACIENTE         HONORARIO             CANTIDAD DE CONSULTAS PRACTICADAS          FECHA       SUBTOTAL");
			while (i < n && facturas.get(i).getFecha().compareTo(hasta) >= 0)
			{ // entro a este ciclo siempre que la factura corresponda al intervalo de fecha
				// [desde;hasta]

				subTotal = 0.0;
				facturas.get(i).muestraPrestacionMedico(medico, subTotal); // busca en la factura si el medico pasado
																			// por parametro atendio al paciente de
																			// dicha factura, de ser asi muestra el
																			// informe
				total += subTotal;
				i++;
			}
			System.out.println("El total recaudado por el medico " + medico.getNombre() + " es: $" + total);
		} else // No encontre ninguna fecha perteneciente al intervalo
			System.out.println("No hay facturas que involucren a el medico " + medico.getNombre()
					+ " en el rango de fechas solicitado solicitado");
	}

}
