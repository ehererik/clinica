package prueba;

import excepciones.MedicoNoEncontradoException;
import excepciones.MismoDniExcepcion;
import excepciones.NoExisteContratacionException;
import excepciones.NoExisteEspecialidadException;
import excepciones.NoExistePosgradoException;
import excepciones.NoHayContratacionException;
import excepciones.NoHayEspecialidadException;
import excepciones.PacienteNoEncontradoExcepcion;
import modelo.Clinica;
import modelo.Compartida;
import modelo.Habitacion;
import modelo.IMedico;
import modelo.MedicoFactory;
import modelo.Paciente;
import modelo.PacienteFactory;
import modelo.Prestacion;
import modelo.Privada;
import modelo.Terapia_Intesiva;

public class Prueba
{

	public static void main(String[] args)
	{
		Clinica unaClinica = Clinica.getInstance();
		unaClinica.setNombre("Clinica Privada");

		try
		{
			unaClinica.agregarMedico(MedicoFactory.getMedico("Jorge", "AAAAAA", "12345678", "domicilio1", "ciudad2",
					"telefono3", 1000, "clinico", null, "residente"));
			System.out.println("Medico agregado con exito");
		} catch (NoHayEspecialidadException e)
		{
			System.out.println(e.getMessage());
		} catch (NoHayContratacionException e)
		{
			System.out.println(e.getMessage());
		} catch (NoExistePosgradoException e)
		{
			System.out.println(e.getMessage());
		} catch (NoExisteContratacionException e)
		{
			System.out.println(e.getMessage());
		} catch (NoExisteEspecialidadException e)
		{
			System.out.println(e.getMessage());
		} catch (MismoDniExcepcion e)
		{
			System.out.println("Ya existe un medico con el dni " + e.getDni());
		}

		try
		{
			unaClinica.agregarMedico(MedicoFactory.getMedico("Raul", "AAAAAA", "1465278", "domicilio1", "ciudad2",
					"telefono3", 1000, "cirujano", "doctor", "plantel permanente"));
			System.out.println("Medico agregado con exito");
		} catch (NoHayEspecialidadException e)
		{
			System.out.println(e.getMessage());
		} catch (NoHayContratacionException e)
		{
			System.out.println(e.getMessage());
		} catch (NoExistePosgradoException e)
		{
			System.out.println(e.getMessage());
		} catch (NoExisteContratacionException e)
		{
			System.out.println(e.getMessage());
		} catch (NoExisteEspecialidadException e)
		{
			System.out.println(e.getMessage());
		} catch (MismoDniExcepcion e)
		{
			System.out.println("Ya existe un medico con el dni " + e.getDni());
		}

		try
		{
			unaClinica.agregarMedico(MedicoFactory.getMedico("Miguel", "AAAAAA", "98431800", "domicilio1", "ciudad2",
					"telefono3", 1000, "pediatra", "magister", "residente"));
			System.out.println("Medico agregado con exito");
		} catch (NoHayEspecialidadException e)
		{
			System.out.println(e.getMessage());
		} catch (NoHayContratacionException e)
		{
			System.out.println(e.getMessage());
		} catch (NoExistePosgradoException e)
		{
			System.out.println(e.getMessage());
		} catch (NoExisteContratacionException e)
		{
			System.out.println(e.getMessage());
		} catch (NoExisteEspecialidadException e)
		{
			System.out.println(e.getMessage());
		} catch (MismoDniExcepcion e)
		{
			System.out.println("Ya existe un medico con el dni " + e.getDni());
		}

		try
		{
			unaClinica.altaPaciente(
					PacienteFactory.getPaciente("joven", "aaaaaa", "1", "calle 123", "marpla city", "1234", "joven"));
		} catch (MismoDniExcepcion e)
		{
			System.out.println("Ya existe un paciente con el mismo dni");
		}

		try
		{
			unaClinica.altaPaciente(
					PacienteFactory.getPaciente("ninio", "aaaaaa", "2", "calle 123", "marpla city", "1234", "ninio"));
		} catch (MismoDniExcepcion e)
		{
			System.out.println("Ya existe un paciente con el mismo dni");
		}

		try
		{
			unaClinica.altaPaciente(
					PacienteFactory.getPaciente("mayor", "aaaaaa", "3", "calle 123", "marpla city", "1234", "mayor"));
		} catch (MismoDniExcepcion e)
		{
			System.out.println("Ya existe un paciente con el mismo dni");
		}

		try
		{
			unaClinica.ingresaPaciente(unaClinica.consultarPaciente("1"));
		} catch (PacienteNoEncontradoExcepcion e)
		{
			System.out.println(e.getMessage());
		}

		unaClinica.muestraPacPatio();
		unaClinica.muestraPacSalaPriv();
		System.out.println("///////////////");

		try
		{
			unaClinica.ingresaPaciente(unaClinica.consultarPaciente("2"));
		} catch (PacienteNoEncontradoExcepcion e)
		{
			System.out.println(e.getMessage());
		}

		unaClinica.muestraPacPatio();
		unaClinica.muestraPacSalaPriv();
		System.out.println("///////////////");

		try
		{
			unaClinica.ingresaPaciente(unaClinica.consultarPaciente("3"));
		} catch (PacienteNoEncontradoExcepcion e)
		{
			System.out.println(e.getMessage());
		}

		unaClinica.muestraPacPatio();
		unaClinica.muestraPacSalaPriv();
		System.out.println("///////////////");

		unaClinica.atenderPaciente();
		unaClinica.muestraPacientesAtencion();
		System.out.println("///////////////");

		unaClinica.atenderPaciente();
		unaClinica.muestraPacientesAtencion();
		System.out.println("///////////////");

		unaClinica.atenderPaciente();
		unaClinica.muestraPacientesAtencion();
		System.out.println("///////////////");

		unaClinica.muestraPacPatio();
		unaClinica.muestraPacSalaPriv();
		System.out.println("///////////////");

		unaClinica.atenderPaciente();
		System.out.println("///////////////");

		Habitacion h1 = new Compartida(1000);
		Habitacion h2 = new Privada(2000);
		Habitacion h3 = new Terapia_Intesiva(5000);

		IMedico m1 = null;
		IMedico m2 = null;
		IMedico m3 = null;

		try
		{
			m1 = unaClinica.devuelveMedico("12345678");
		} catch (MedicoNoEncontradoException e1)
		{
			e1.getMessage();
		}

		try
		{
			m2 = unaClinica.devuelveMedico("98431800");
		} catch (MedicoNoEncontradoException e1)
		{
			e1.getMessage();
		}

		try
		{
			m3 = unaClinica.devuelveMedico("1465278");
		} catch (MedicoNoEncontradoException e1)
		{
			e1.getMessage();
		}

		Prestacion p1 = new Prestacion(m1, 3);
		Prestacion p2 = new Prestacion(m2, 7);
		Prestacion p3 = new Prestacion(m3, 1);
		Prestacion p4 = new Prestacion(m3, 5);
		Prestacion p5 = new Prestacion(m1, 10);

		Prestacion p6 = new Prestacion(h1, 20);
		Prestacion p7 = new Prestacion(h2, 13);
		Prestacion p8 = new Prestacion(h2, 3);
		Prestacion p9 = new Prestacion(h3, 5);
		Prestacion p10 = new Prestacion(h1, 4);

		Paciente paciente1 = null, paciente2 = null, paciente3 = null;

		try
		{
			paciente1 = unaClinica.consultarPaciente("1");
		} catch (PacienteNoEncontradoExcepcion e)
		{
			System.out.println("El paciente con dni " + e.getDni() + " no esta en el hospital ");
		}
		try
		{
			paciente2 = unaClinica.consultarPaciente("2");
		} catch (PacienteNoEncontradoExcepcion e)
		{
			System.out.println("El paciente con dni " + e.getDni() + " no esta en el hospital ");
		}
		try
		{
			paciente3 = unaClinica.consultarPaciente("3");
		} catch (PacienteNoEncontradoExcepcion e)
		{
			System.out.println("El paciente con dni " + e.getDni() + " no esta en el hospital ");
		}

		paciente1.agregarPrestacion(p1);
		paciente1.agregarPrestacion(p5);
		paciente1.agregarPrestacion(p9);
		paciente1.agregarPrestacion(p2);

		paciente2.agregarPrestacion(p10);
		paciente2.agregarPrestacion(p1);
		paciente2.agregarPrestacion(p4);
		paciente2.agregarPrestacion(p8);
		paciente2.agregarPrestacion(p6);

		paciente3.agregarPrestacion(p2);

		try
		{
			unaClinica.darAltaYFacturar(paciente2);
		} catch (PacienteNoEncontradoExcepcion e)
		{
			System.out.println(e.getMessage());
			System.out.println("PACIENTE INVALIDO: " + e.getPaciente());
		}

		try
		{
			unaClinica.darAltaYFacturar(paciente1);
		} catch (PacienteNoEncontradoExcepcion e)
		{
			e.printStackTrace();
		}

		try
		{
			unaClinica.darAltaYFacturar(paciente3);
		} catch (PacienteNoEncontradoExcepcion e)
		{
			e.printStackTrace();
		}

	}

}
