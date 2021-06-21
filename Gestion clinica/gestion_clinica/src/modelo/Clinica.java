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
import excepciones.NoExisteContratacionException;
import excepciones.NoExisteEspecialidadException;
import excepciones.NoExistePosgradoException;
import excepciones.NoHayContratacionException;
import excepciones.NoHayEspecialidadException;
import excepciones.PacienteNoEncontradoExcepcion;




/**
 * <br> Clase Clinica encargada de gestionar el sistema, cuyos atributos son: (detalles de implemntacion explicativas para los profesores).</br>
 * <br> -static Clinica instance: Intancia de la clinica para acceder a ella con el patron singleton.</br>
 * <br> - String nombre: Nombre de la clinica.</br>
 *<br> - HashMap<String,Paciente> pacientes: Hash map que contiene los pacientes registrados en la clinica (key=dni).</br>
 *<br>- HashMap<String,Paciente> atencion: Hash map que contiene los pacientes en atencion (key=dni).</br>
 *<br>- HashMap<String,Paciente> medicos: Hash map que contiene los medicos de la clinica (key=dni).</br>
 *<br>-Queue<Paciente> colaDeEspera: Cola que tiene los pacientes ingresados esperando por atencion por orden de llegada.</br>
 *<br>- Sala_privada salaPriv: puede contener 0 o 1 paciente segun prioridad de pacientes para esperar ser atendido.</br>
 *<br>-Patio pat: puede contener 0 o mas pacientes segun prioridad de pacientes para esperar ser atendidos.</br>
 *<br>- static int nroORden: variable statica que asigana numero de orden por orden de llegada a los pacientes en espera para ser atendidos.</br>
 */
public class Clinica {
	
	private static Clinica instance = null;
	private String nombre;

	HashMap<String, Paciente> pacientes = new HashMap<String, Paciente>();
	HashMap<String, Paciente> atencion = new HashMap<String, Paciente>();
	HashMap<String, IMedico> medicos = new HashMap<String, IMedico>();
	private Queue<Paciente> colaDeEspera = new LinkedList<>();
	private Sala_privada salaPriv;
	private Patio pat;
	private static int nroORden = 0;

	ArrayList<Factura> facturas = new ArrayList<>();

	
	 /**Obtener instancia con patron singleton
     * @return instancia clinica
     */
	public static Clinica getInstance() {
		if (instance == null)
			instance = new Clinica();
		return instance;
	}

	private Clinica() {
		super();
		salaPriv = Sala_privada.getInstace();
		pat = Patio.getInstance();
	}

	
	
	 /** 
     * @param medico objeto medico precondicion distinto de null
     * @throws MismoDniExcepcion si ya hay un medico con el mismo dni propaga la excepcion
     * post Da de alta nuevo medico para ser usado en el sistema
     */
	public void agregarMedico(IMedico medico) throws MismoDniExcepcion {
		if (this.medicos.get(medico.getDni()) != null)
			throw new MismoDniExcepcion(medico.getDni());
		else
			this.medicos.put(medico.getDni(), medico);
	}

	
	
	
	 /**
     * @param dni pre: dni formato valido a cargo del usuario
     * @throws MedicoNoEncontradoException Si el dni enviado no es igual a ninguno de los medicos de la clinica lanza la execepcion
     * post se da la baja del medico del sistema
     */
	public void removerMedico(String dni) throws MedicoNoEncontradoException {
		if (this.medicos.remove(dni) == null)
			throw new MedicoNoEncontradoException("El medico no forma parte del hospital", dni);
	}

	
	
	/**
     * @param p objeto paciente precondicion distinto de null
     * @throws MismoDniExcepcion si ya hay un medico con el mismo dni propaga la excepcion
     * post Da de alta nuevo paciente para ser usado en el sisteman
     */
	public void altaPaciente(Paciente p) throws MismoDniExcepcion {
		if (this.pacientes.get(p.getDni()) != null)
			throw new MismoDniExcepcion(p.getDni());
		else
			this.pacientes.put(p.getDni(), p);
		System.out.println("Paciente agregado con exito");
	}

	public IMedico devuelveMedico(String dni) throws MedicoNoEncontradoException
	{
		if(this.medicos.get(dni) == null)
			throw new MedicoNoEncontradoException("El medico no forma parte del hospital", dni);	
		return this.medicos.get(dni);
	}

	
	
	
	/**
     * @param dni pre condi string valido
     * @return clon de l paciente con dni buscado
     * @throws PacienteNoEncontradoExcepcion si el dni no esta regristado
     */
	public Paciente consultarPaciente(String dni) throws PacienteNoEncontradoExcepcion {
		Paciente p1;
		p1 = null;
		try {
			if (!this.pacientes.isEmpty()) {
				p1 = this.pacientes.get(dni);
				if (p1 != null)
					p1 = (Paciente) p1.clone();
			}
		} catch (CloneNotSupportedException e) {
		}
		if (p1 == null)
			throw new PacienteNoEncontradoExcepcion("El paciente no se encuentra en el hospital.", dni);
		else
			return p1;
	}

	
	
	
	  /**
     * @param dni pre condi string valido
     * @throws PacienteNoEncontradoExcepcion si el dni no esta regristado
     * * post se da la baja del medico del sistema
     */
	public void removerPaciente(String dni) throws PacienteNoEncontradoExcepcion {
		if (this.pacientes.remove(dni) == null)
			throw new PacienteNoEncontradoExcepcion("El paciente no se encuentra en el hospital.", dni);

	}

	
	
	 /**
     * @param dni pre cadena valida
     * @param nom pre cadena valida
     * @param ape pre cadena valida
     * @throws PacienteNoEncontradoExcepcion si el dni no esta regristado
     * post cambia nombre y apellido del pacietne solicitado
     */
	public void modPacienteNomyApe(String dni, String nom, String ape) throws PacienteNoEncontradoExcepcion {
		Paciente p1;
		p1 = null;
		try {
			if (!this.pacientes.isEmpty())
				p1 = (Paciente) this.pacientes.get(dni).clone();
		} catch (CloneNotSupportedException e) {
		}
		if (p1 == null)
			throw new PacienteNoEncontradoExcepcion("El paciente no se encuentra en el hospital.", dni);

		else {
			p1.setNombre(nom);
			p1.setApellido(ape);
			this.pacientes.remove(p1.getDni());
			this.pacientes.put(p1.getDni(), p1);
		}
	}

	public void modPacienteDom(String dni, String dom) throws PacienteNoEncontradoExcepcion {
		Paciente p1;
		p1 = null;
		try {
			if (!this.pacientes.isEmpty())
				p1 = (Paciente) this.pacientes.get(dni).clone();
		} catch (CloneNotSupportedException e) {
		}
		if (p1 == null)
			throw new PacienteNoEncontradoExcepcion("El paciente no se encuentra en el hospital.", dni);

		else {
			p1.setDomicilio(dom);
			this.pacientes.remove(p1.getDni());
			this.pacientes.put(p1.getDni(), p1);
		}
	}

	public void modPacienteTel(String dni, String tel) throws PacienteNoEncontradoExcepcion {
		Paciente p1;
		p1 = null;
		try {
			if (!this.pacientes.isEmpty())
				p1 = (Paciente) this.pacientes.get(dni).clone();
		} catch (CloneNotSupportedException e) {
		}
		if (p1 == null)
			throw new PacienteNoEncontradoExcepcion("El paciente no se encuentra en el hospital.", dni);

		else {
			p1.setTelefono(tel);
			this.pacientes.remove(p1.getDni());
			this.pacientes.put(p1.getDni(), p1);
		}
	}

	
	
	
	 /**
     * @param p  pre paciente distinto de null Ingresa el paciente la espera de ser atendido por orden de llgada y segun su rango etario decide donde espera
     * post paciente ingresado
     */ 
	public void ingresaPaciente(Paciente p) {
		Paciente pSalaPriv;
		pSalaPriv = null;
		colaDeEspera.add(p);
		p.setNroOrden(nroORden++);
		pSalaPriv = salaPriv.devuelvePaciente();
		if (p.establecerPriotodad(pSalaPriv)) {
			salaPriv.AgregaPaciente(p);
			if (pSalaPriv != null)
				pat.AgregaPaciente(pSalaPriv);
		} else
			pat.AgregaPaciente(p);
	}

	
	
    /**
     * Manda paciente a area de atencion si no hay pacientes indica que esta vacia.
     */
	public void atenderPaciente() {
		Paciente p = null;
		try {
			p = colaDeEspera.remove();
			atencion.put(p.getDni(), p);
			try {
				this.pat.QuitaPaciente(p.getDni());
			} catch (PacienteNoEncontradoExcepcion e) {
				try {
					this.salaPriv.QuitaPaciente(e.getDni());
				} catch (PacienteNoEncontradoExcepcion f) {
					System.out.println("Paciente no encontrado en Ingreso");
				}
			}
		} catch (NoSuchElementException e) {
			System.out.println("No quedan pacientes por ser atendidos");
		}

	}

	

	public void muestraPacientesAtencion() {
		Paciente p;
		p = null;
		Iterator<Paciente> it = this.atencion.values().iterator();
		if (this.atencion.isEmpty())
			System.out.println("Atencion vacia");
		else {
			System.out.println("Pacientes en atecion");
			while (it.hasNext()) {
				try {
					p = (Paciente) it.next().clone();
				} catch (CloneNotSupportedException e) {
				}
				System.out.println(p.getNombre() + " " + p.getDni());
			}
		}
	}

	public void muestraPacSalaPriv() {
		this.salaPriv.muestraPaciente();
	}

	public void muestraPacPatio() {
		this.pat.muestraPacientes();
	}

	public void agregarPrestacionAPaciente(Paciente paciente, Prestacion prestacion) {
		paciente.agregarPrestacion(prestacion);
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return this.nombre;
	}

///////////////////////////// MODULO DE EGRESO Y FACTURACION////////////////////////////////////////////////////////// 
	/**
	 * @param paciente Nombre del paciente a dar de alta y facturar
	 * @param fecha Fecha en que se factura (en un caso real no se tomaria este parametro, se tomaria la fecha del sistema)
	 * @throws PacienteNoEncontradoExcepcion Si el paciente no esta en la clinica se lanza la excepcion
	 */
	public void darAltaYFacturar(Paciente paciente, GregorianCalendar fecha) throws PacienteNoEncontradoExcepcion {

		
		if (!this.atencion.containsKey(paciente.getDni())) {
			throw new PacienteNoEncontradoExcepcion("El paciente no se encuentra en la clinica", paciente);
		}

		System.out.println("\n\n\n\n---------------------------FACTURA - CLINICA: " + this.nombre+"---------------------------------\n\n");
		facturas.add(new Factura(fecha, paciente, paciente.getPrestaciones())); // Crea la factura del paciente

		facturas.get(facturas.size() - 1).muestraFactura(); // Muestra factura del paciente que se ira de la clinica
															

		System.out.println("\nTOTAL: $" + this.facturas.get(facturas.size() - 1).totalFactura() + "\n");
		System.out.println(
				"--------------------------------------------------------------------------------------------------------");
		this.atencion.remove(paciente.getDni()); // saco al paciente de la clinica
	}

///////////////////////////// REPORTE DE ACTIVIDAD MEDICA /////////////////////////////////////////////////////////////		

	
	
	
	/**
	 * Metodo que reporta la actividad de un medico dentro un rango de fechas . <br>
	 * @param medico Medico del cual se reporta su actividad
	 * @param desde Limite inferior del rango de fecha a mostrar
	 * @param hasta Limite superior del rango de fecha a mostrar
	 */
	
	public void reporteActividadMedica(IMedico medico, GregorianCalendar desde, GregorianCalendar hasta) {

		int i = 0;
		int n = facturas.size();
		double total;

		total = 0;

		while (i < n && facturas.get(i).getFecha().compareTo(desde) < 0)// BUSCO EN EL ARRAY DE FACTURAS HASTA ENCONTRAR
																		// LA FECHA "desde" o una mayor
			i++;

		if (i < n) { // Encontre una fecha perteneciente al intervalo

			System.out.println("\nConsultas atendidas por el medico/a " + medico.getNombre() + " desde "
					+ this.muestraFecha(desde) + " hasta " + this.muestraFecha(hasta));
			System.out.println(
					"    NOMBRE DEL PACIENTE         HONORARIO             CANTIDAD DE CONSULTAS PRACTICADAS          FECHA                 SUBTOTAL");

			while (i < n && facturas.get(i).getFecha().compareTo(hasta) <= 0) { // entro a este ciclo siempre que la
																				// factura corresponda al intervalo de
																				// fecha
																				// [desde;hasta]

				 total += facturas.get(i).muestraPrestacionMedico(medico); // busca en la factura si el  medico pasado por parametro atendio al
																		   //paciente de  dicha factura, de ser asi muestra el informe
				i++;
			}
			System.out.println("El total recaudado por el medico " + medico.getNombre() + " es: $" + total);
		} else // No se encontro ninguna fecha perteneciente al intervalo
			System.out.println("No hay facturas que involucren a el medico " + medico.getNombre()+ " en el rango de fechas solicitado");
	}

	
	
	
	
	public String muestraFecha(GregorianCalendar fecha) {
		return fecha.get(Calendar.DATE) + "/" + fecha.get(Calendar.MONTH) + "/" + fecha.get(Calendar.YEAR);
	}

}
