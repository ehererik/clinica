package modelo;

public class PacienteFactory
{
	public static Paciente getPaciente(String nombre, String apellido, String dni, String domicilio, String ciudad, String telefono, String rangoEtario)
	{
		Paciente respuesta = null;
		
		if(rangoEtario.equalsIgnoreCase("NINIO"))
			respuesta = new Ninio(nombre,apellido,dni,domicilio,ciudad,telefono);
		if(rangoEtario.equalsIgnoreCase("JOVEN"))
			respuesta = new Joven(nombre,apellido,dni,domicilio,ciudad,telefono);
		if(rangoEtario.equalsIgnoreCase("MAYOR"))
			respuesta = new Mayor(nombre,apellido,dni,domicilio,ciudad,telefono);
		
		return respuesta;
	}
}
