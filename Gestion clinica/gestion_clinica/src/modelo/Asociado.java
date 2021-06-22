package modelo;

import java.util.Random;

import util.Util;

public class Asociado extends Persona implements Runnable
{
	private Clinica clinica;
	private static Random r = new Random();
	private int solicitud;
	
	public Asociado(String nombre, String apellido, String dni, String domicilio, String telefono, Clinica clinica)
	{
		super(nombre,apellido,dni,domicilio,telefono);
		this.clinica = clinica;
	}

	@Override
	public void run()
	{
		
		for(int i=0; i<10 ; i++)
		{
			solicitud = r.nextInt(2);
			if(solicitud == 1)
			{
				Util.esperaRandom(3000);
				this.clinica.solicitarAtecionDomicilio();
				Util.espera();
				this.clinica.volverAClinica();
			}
			else
			{
				Util.esperaRandom(3000);
				this.clinica.trasladoClinica();
				Util.espera();
				this.clinica.volverAClinica();
			}
			Util.esperaRandom(1000);
		}
		
	}
	
}
