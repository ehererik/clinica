package modelo;

import util.Util;

public class Temporizador implements Runnable
{
	private Ambulancia ambulancia;
	
	public Temporizador(Ambulancia ambulancia)
	{
		this.ambulancia = ambulancia;
	}
	
	@Override
	public void run()
	{
		Util.esperaRandom(1000);
		this.ambulancia.volverAClinica();
		if(this.ambulancia.getDisponible() == false)
		{
			Util.esperaRandom(1000);
			this.ambulancia.ambulanciaDisponible();
		}
		this.ambulancia.setDisponible();
	}

}
