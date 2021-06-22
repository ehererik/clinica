package modelo;

import util.Util;

public class Operario implements Runnable
{
	private static Operario Instance; 
	private Clinica clinica;
	
	public static Operario getInstance()
	{
		if(Operario.Instance == null)
			Operario.Instance = new Operario();
		return Operario.Instance;
	}
	
	private Operario(){}
	
	
	protected void setClinica(Clinica clinica)
	{
		this.clinica = clinica;
	}
	
	
	@Override
	public void run()
	{
		
		for(int i=0; i<10 ; i++)
		{
			Util.esperaRandom(3000);
			this.clinica.repararAmbulancia();
			Util.espera();
			this.clinica.volverAClinica();
			Util.esperaRandom(1000);
		}
	}

}
