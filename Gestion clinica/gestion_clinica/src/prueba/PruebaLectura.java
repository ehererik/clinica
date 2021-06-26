package prueba;

import java.io.IOException;
import java.util.HashMap;

import modelo.Asociado;
import modelo.Clinica;
import modelo.IMedico;
import modelo.Paciente;
import persistencia.IPersistencia;
import persistencia.PersistenciaBIN;

public class PruebaLectura
{

	public static void main(String[] args)
	{
		IPersistencia persistencia = new PersistenciaBIN();
        Clinica unaClinica = Clinica.getInstance();
		
        HashMap<String, Paciente> pacientes = new HashMap<String, Paciente>();
    	HashMap<String, IMedico> medicos = new HashMap<String, IMedico>();
    	HashMap<String, Asociado> asociados = new HashMap<String, Asociado>();
        
    	
    	//--------------------LECTURA-DE-PACIENTES-----------------------------------------
        try
        {
            persistencia.abrirInput("Pacientes.bin");
            System.out.println("Archivo Pacientes.bin abierto");
            pacientes = (HashMap<String, Paciente>) persistencia.leer();
            System.out.println("Lista de pacientes recuperada");
            persistencia.cerrarInput();
            System.out.println("Archivo Pacientes.bin cerado");
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }	
		
      //--------------------LECTURA-DE-MEDICOS-----------------------------------------
        try
        {
            persistencia.abrirInput("Medicos.bin");
            System.out.println("Archivo Medicos.bin abierto");
            medicos = (HashMap<String, IMedico>) persistencia.leer();
            System.out.println("Lista de medicos recuperada");
            persistencia.cerrarInput();
            System.out.println("Archivo Medicos.bin cerado");
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }	
        
      //--------------------LECTURA-DE-ASOCIADOS-----------------------------------------
        try
        {
            persistencia.abrirInput("Asociados.bin");
            System.out.println("Archivo Asociados.bin abierto");
            asociados = (HashMap<String, Asociado>) persistencia.leer();
            System.out.println("Lista de asociados recuperada");
            persistencia.cerrarInput();
            System.out.println("Archivo Asociados.bin cerado");
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }	
		
		unaClinica.setAsociados(asociados);
		unaClinica.setMedicos(medicos);
		unaClinica.setPacientes(pacientes);
		
		System.out.println("Asociados:");
		unaClinica.listaAsociados();
		System.out.println("Medicos:");
		unaClinica.listaMedicos();
		System.out.println("Pacientes:");
		unaClinica.listaPacientes();
		
		
		
	}

}
