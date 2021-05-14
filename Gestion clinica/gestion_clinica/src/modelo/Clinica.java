package modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

import excepciones.MedicoNoEncontradoException;
import excepciones.MismoDniExcepcion;
import excepciones.PacienteNoEncontradoExcepcion;

public class Clinica
{
	private static Clinica instance = null;
	private String nombre;

	HashMap<String, Paciente> pacientes = new HashMap<String, Paciente>();
	HashMap<String, Paciente> atencion = new HashMap<String, Paciente>();
	HashMap<String, IMedico> medicos = new HashMap<String, IMedico>();
	private Queue<Paciente> colaDeEspera = new LinkedList<>();
	private Sala_privada salaPriv;
	private Patio pat;
	private static int nroORden = 0;
	private static GregorianCalendar horaActual = new GregorianCalendar();

	ArrayList<Factura> facturas = new ArrayList<>();

	public static Clinica getInstance()
	{
		if (instance == null)
			instance = new Clinica();
		return instance;
	}

	private Clinica()
	{
		super();
		salaPriv = Sala_privada.getInstace();
		pat = Patio.getInstance();
	}

	public void agregarMedico(IMedico medico) throws MismoDniExcepcion
	{
		if (this.medicos.get(medico.getDni()) != null)
			throw new MismoDniExcepcion(medico.getDni());
		else
			this.medicos.put(medico.getDni(), medico);
	}

	public void removerMedico(String dni) throws MedicoNoEncontradoException
	{
		if (this.medicos.remove(dni) == null)
			throw new MedicoNoEncontradoException("El medico no forma parte del hospital", dni);
	}

	public void altaPaciente(Paciente p) throws MismoDniExcepcion
	{
		if (this.pacientes.get(p.getDni()) != null)
			throw new MismoDniExcepcion(p.getDni());
		else
			this.pacientes.put(p.getDni(), p);
		System.out.println("Paciente agregado con exito");
	}
	
	public IMedico devuelveMedico(String dni)
	{
		IMedico m = null;
		
		
		return this.medicos.get(dni);
	}
	
	public Paciente consultarPaciente(String dni) throws PacienteNoEncontradoExcepcion
	{
		Paciente p1;
		p1 = null;
		try
		{
			if (!this.pacientes.isEmpty())
			{
				p1 = this.pacientes.get(dni);
				if (p1 != null)
					p1 = (Paciente) p1.clone();
			}
		} catch (CloneNotSupportedException e)
		{
		}
		if (p1 == null)
			throw new PacienteNoEncontradoExcepcion("El paciente no se encuentra en el hospital.", dni);
		else
			return p1;
	}

	public void removerPaciente(String dni) throws PacienteNoEncontradoExcepcion
	{
		if (this.pacientes.remove(dni) == null)
			throw new PacienteNoEncontradoExcepcion("El paciente no se encuentra en el hospital.", dni);

	}

	public void modPacienteNomyApe(String dni, String nom, String ape) throws PacienteNoEncontradoExcepcion
	{
		Paciente p1;
		p1 = null;
		try
		{
			if (!this.pacientes.isEmpty())
				p1 = (Paciente) this.pacientes.get(dni).clone();
		} catch (CloneNotSupportedException e)
		{
		}
		if (p1 == null)
			throw new PacienteNoEncontradoExcepcion("El paciente no se encuentra en el hospital.", dni);

		else
		{
			p1.setNombre(nom);
			p1.setApellido(ape);
			this.pacientes.remove(p1.getDni());
			this.pacientes.put(p1.getDni(), p1);
		}
	}

	public void modPacienteDom(String dni, String dom) throws PacienteNoEncontradoExcepcion
	{
		Paciente p1;
		p1 = null;
		try
		{
			if (!this.pacientes.isEmpty())
				p1 = (Paciente) this.pacientes.get(dni).clone();
		} catch (CloneNotSupportedException e)
		{
		}
		if (p1 == null)
			throw new PacienteNoEncontradoExcepcion("El paciente no se encuentra en el hospital.", dni);

		else
		{
			p1.setDomicilio(dom);
			this.pacientes.remove(p1.getDni());
			this.pacientes.put(p1.getDni(), p1);
		}
	}

	public void modPacienteTel(String dni, String tel) throws PacienteNoEncontradoExcepcion
	{
		Paciente p1;
		p1 = null;
		try
		{
			if (!this.pacientes.isEmpty())
				p1 = (Paciente) this.pacientes.get(dni).clone();
		} catch (CloneNotSupportedException e)
		{
		}
		if (p1 == null)
			throw new PacienteNoEncontradoExcepcion("El paciente no se encuentra en el hospital.", dni);

		else
		{
			p1.setTelefono(tel);
			this.pacientes.remove(p1.getDni());
			this.pacientes.put(p1.getDni(), p1);
		}
	}

	public void ingresaPaciente(Paciente p)
	{
		Paciente pSalaPriv;
		pSalaPriv = null;
		colaDeEspera.add(p);
		p.setNroOrden(nroORden++);
		pSalaPriv = salaPriv.devuelvePaciente();
		if (p.establecerPriotodad(pSalaPriv))
		{
			salaPriv.AgregaPaciente(p);
			if (pSalaPriv != null)
				pat.AgregaPaciente(pSalaPriv);
		} else
			pat.AgregaPaciente(p);
	}

	public void atenderPaciente()
	{
		Paciente p = null;
		try
		{
			p = colaDeEspera.remove();
			atencion.put(p.getDni(), p);
			try
			{
				this.pat.QuitaPaciente(p.getDni());
			} catch (PacienteNoEncontradoExcepcion e)
			{
				try
				{
					this.salaPriv.QuitaPaciente(e.getDni());
				} catch (PacienteNoEncontradoExcepcion f)
				{
					System.out.println("Paciente no encontrado en Ingreso");
				}
			}
		} catch (NoSuchElementException e)
		{
			System.out.println("No quedan pacientes por ser atendidos");
		}

	}

	public void removerPacienteAtencion(String dni)
	{
		atencion.remove(dni);
	}

	public void muestraPacientesAtencion()
	{
		Paciente p;
		p = null;
		Iterator<Paciente> it = this.atencion.values().iterator();
		if (this.atencion.isEmpty())
			System.out.println("Atencion vacia");
		else
		{
			System.out.println("Pacientes en atecion");
			while (it.hasNext())
			{
				try
				{
					p = (Paciente) it.next().clone();
				} catch (CloneNotSupportedException e)
				{
				}
				System.out.println(p.getNombre() + " " + p.getDni());
			}
		}
	}

	public void muestraPacSalaPriv()
	{
		this.salaPriv.muestraPaciente();
	}

	public void muestraPacPatio()
	{
		this.pat.muestraPacientes();
	}

	public void agregarPrestacionAPaciente(Paciente paciente, Prestacion prestacion)
	{
		paciente.agregarPrestacion(prestacion);
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public String getNombre()
	{
		return this.nombre;
	}

///////////////////////////// MODULO DE EGRESO Y FACTURACION////////////////////////////////////////////////////////// 
	public void darAltaYFacturar(Paciente paciente)  throws PacienteNoEncontradoExcepcion
	{

		if (this.atencion.get(paciente.getDni()).equals(null))
		{
			throw new PacienteNoEncontradoExcepcion("El paciente no se encuentra en la clinica", paciente);
		}

		Clinica.horaActual.add(Calendar.HOUR, (int) Math.floor(Math.random() * (9 - 7 + 1) + 7));

		facturas.add(new Factura(horaActual, paciente, paciente.getPrestaciones())); // Crea la factura del paciente
		
		facturas.get(facturas.size() - 1).muestraFactura();                 // Muestra factura del paciente que se ira de
																			// la clinica
		
		System.out.println("TOTAL: $" + this.facturas.get(facturas.size() - 1).totalFactura() );
		
		this.atencion.remove(paciente.getDni()); // saco al paciente de la clinica
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
