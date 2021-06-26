package prueba;

import java.io.IOException;

import excepciones.MismoDniExcepcion;
import excepciones.NoExisteContratacionException;
import excepciones.NoExisteEspecialidadException;
import excepciones.NoExistePosgradoException;
import excepciones.NoHayContratacionException;
import excepciones.NoHayEspecialidadException;
import modelo.Asociado;
import modelo.Clinica;
import modelo.MedicoFactory;
import modelo.PacienteFactory;
import persistencia.IPersistencia;
import persistencia.PersistenciaBIN;

public class PruebaEscritura
{

	public static void main(String[] args)
    {
        //IPersistencia persistencia = new PersistenciaXML();
        IPersistencia persistencia = new PersistenciaBIN();
        Clinica unaClinica = Clinica.getInstance();
        
        try {
			unaClinica.agregarMedico(MedicoFactory.getMedico("Jorge", "Reynoso", "12345678", "domicilio1", "Mar del Plata",
					"223-5523487", 5000, "clinico", null, "residente"));
			System.out.println("Medico agregado con exito");
		} catch (NoHayEspecialidadException e) {
			System.out.println(e.getMessage());
		} catch (NoHayContratacionException e) {
			System.out.println(e.getMessage());
		} catch (NoExistePosgradoException e) {
			System.out.println(e.getMessage());
		} catch (NoExisteContratacionException e) {
			System.out.println(e.getMessage());
		} catch (NoExisteEspecialidadException e) {
			System.out.println(e.getMessage());
		} catch (MismoDniExcepcion e) {
			System.out.println("Ya existe un medico con el dni " + e.getDni());
		}

		try {
			unaClinica.agregarMedico(MedicoFactory.getMedico("Marisa", "Gutierrez", "1465278", "domicilio2", "Mar del Plata",
					"223-64521324", 10000, "cirujano", "doctor", "plantel permanente"));
			System.out.println("Medico agregado con exito");
		} catch (NoHayEspecialidadException e) {
			System.out.println(e.getMessage());
		} catch (NoHayContratacionException e) {
			System.out.println(e.getMessage());
		} catch (NoExistePosgradoException e) {
			System.out.println(e.getMessage());
		} catch (NoExisteContratacionException e) {
			System.out.println(e.getMessage());
		} catch (NoExisteEspecialidadException e) {
			System.out.println(e.getMessage());
		} catch (MismoDniExcepcion e) {
			System.out.println("Ya existe un medico con el dni " + e.getDni());
		}

		try {
			unaClinica.agregarMedico(MedicoFactory.getMedico("Miguel", "Patane", "98431800", "domicilio3", "Mar del Tuyu",
					"223-45456454", 1000, "pediatra", "magister", "residente"));
			System.out.println("Medico agregado con exito");
		} catch (NoHayEspecialidadException e) {
			System.out.println(e.getMessage());
		} catch (NoHayContratacionException e) {
			System.out.println(e.getMessage());
		} catch (NoExistePosgradoException e) {
			System.out.println(e.getMessage());
		} catch (NoExisteContratacionException e) {
			System.out.println(e.getMessage());
		} catch (NoExisteEspecialidadException e) {
			System.out.println(e.getMessage());
		} catch (MismoDniExcepcion e) {
			System.out.println("Ya existe un medico con el dni " + e.getDni());
		}
        
		try {
			unaClinica.altaPaciente(
					PacienteFactory.getPaciente("Nahuel", "Spatera", "1", "calle 123", "Mar de Ajo", "223-1251213", "joven"));
		} catch (MismoDniExcepcion e) {
			System.out.println("Ya existe un paciente con el mismo dni");
		}

		try {
			unaClinica.altaPaciente(
					PacienteFactory.getPaciente("Tomas", "Barrios", "2", "calle 123", "Mar del Plata", "223-5566687", "ninio"));
		} catch (MismoDniExcepcion e) {
			System.out.println("Ya existe un paciente con el mismo dni");
		}

		try {
			unaClinica.altaPaciente(
					PacienteFactory.getPaciente("Diego", "Maradona", "3", "calle 123", "Villa Fiorito", "223-6546682", "mayor"));
		} catch (MismoDniExcepcion e) {
			System.out.println("Ya existe un paciente con el mismo dni");
		}
        
        
		try
		{
			unaClinica.agregarAsociado(new Asociado("Jorge","Perez","123456","independencia 3000","4563.21"));
		} catch (MismoDniExcepcion e)
		{
			e.printStackTrace();
		}
		
		try
		{
			unaClinica.agregarAsociado(new Asociado("Raul","Dematteis","74516r","independencia 3000","4563.21"));
		} catch (MismoDniExcepcion e)
		{
			e.printStackTrace();
		}
		
		try
		{
			unaClinica.agregarAsociado(new Asociado("Miguel","Rodriguez","355411325","independencia 3000","4563.21"));
		} catch (MismoDniExcepcion e)
		{
			e.printStackTrace();
		}
        

        try
        {
        	persistencia.abrirOutput("Pacientes.bin");
            System.out.println("Creando/sobreescribiendo archivo escritura Pacientes.bin");
            persistencia.escribir(unaClinica.getPacientes());
            System.out.println("Lista de pacientes grabada exitosamente");
            persistencia.cerrarOutput();
            System.out.println("Archivo Pacientes.bin cerrado");
        } catch (IOException e)
        {
            System.out.println(e.getLocalizedMessage());
        }
        
        try
        {
        	persistencia.abrirOutput("Asociados.bin");
            System.out.println("Creando/sobreescribiendo archivo escritura Asociados.bin");
            persistencia.escribir(unaClinica.getAsociados());
            System.out.println("Lista de asociados grabada exitosamente");
            persistencia.cerrarOutput();
            System.out.println("Archivo Asociados.bin cerrado");
        } catch (IOException e)
        {
            System.out.println(e.getLocalizedMessage());
        }
        
        try
        {
        	persistencia.abrirOutput("Medicos.bin");
            System.out.println("Creando/sobreescribiendo archivo escritura Medicos.bin");
            persistencia.escribir(unaClinica.getMedicos());
            System.out.println("Lista de medicos grabada exitosamente");
            persistencia.cerrarOutput();
            System.out.println("Archivo Medicos.bin cerrado");
        } catch (IOException e)
        {
            System.out.println(e.getLocalizedMessage());
        }
        
    }

}
