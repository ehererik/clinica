package modelo;

public class MedicoFactory
{
	public static IMedico getMedico(String nombre, String apellido, String dni, String domicilio, String ciudad, String telefono, double sueldoBase,String especialidad, String posgrado, String contratacion)
	{
		IMedico encapsulado1 = null;
		IMedico encapsulado2 = null;
		IMedico respuesta = null;
		
		if(especialidad == null) //excepcion -> no tiene especialidad
		{
			
		}
		if(especialidad.equalsIgnoreCase("CLINICO"))
			encapsulado1 = new Clinico(nombre,apellido,dni,domicilio,ciudad,telefono,sueldoBase);
		else if(especialidad.equalsIgnoreCase("CIRUJANO"))
			encapsulado1 = new Cirujano(nombre,apellido,dni,domicilio,ciudad,telefono,sueldoBase);
		else if(especialidad.equalsIgnoreCase("PEDIATRA"))
			encapsulado1 = new Pediatra(nombre,apellido,dni,domicilio,ciudad,telefono,sueldoBase);
		
		if(encapsulado1 != null) //la especialidad es válida
		{
			if(posgrado != null)
			{
				if(posgrado.equalsIgnoreCase("DOCTOR"))
					encapsulado2 = new DDoctor(encapsulado1);
				else if(posgrado.equalsIgnoreCase("MAGISTER"))
					encapsulado2 = new DMagister(encapsulado1);
				else //excepcion -> no existe el posgrado 
				{
					
					
					
				}
				
			}
			if(encapsulado2 != null) //tiene posgrado
			{
				if(contratacion == null) //excepcion -> no hay contratacion
				{
					
				}
				else if(contratacion.equalsIgnoreCase("RESIDENTE"))
					respuesta = new DResidente(encapsulado2);
				else if(contratacion.equalsIgnoreCase("PLANTEL PERMANENTE"))
					respuesta = new DPermanente(encapsulado2);
				else //excepcion -> no existe el tipo de contratacion
				{
					
				}
			}
			else //no tiene un posgrado
			{
				if(contratacion == null) //excepcion -> no hay contratacion
				{
					
				}
				else if(contratacion.equalsIgnoreCase("RESIDENTE"))
					respuesta = new DResidente(encapsulado1);
				else if(contratacion.equalsIgnoreCase("PLANTEL PERMANENTE"))
					respuesta = new DPermanente(encapsulado1);
				else //excepcion -> no existe el tipo de contratacion
				{
					
				}
				
			}
		}
		else // excepcion -> la especialidad no existe
		{
			
		}
		
		return respuesta;
	}
}