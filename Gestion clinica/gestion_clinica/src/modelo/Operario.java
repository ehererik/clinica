package modelo;

import util.Util;

public class Operario extends Persona implements Runnable
{
	private static final long serialVersionUID = 1281335842;
	private static Operario Instance; 
	private Ambulancia ambulancia;
	private int cantSolicitudes = 4;
	private String accion;
	
	public String getAccion()
	{
		return this.accion;
	}
	
	public static Operario getInstance()
	{
		if(Operario.Instance == null)
			Operario.Instance = new Operario();
		return Operario.Instance;
	}
	
	private Operario()
	{
		super();
	}
	
	protected void setAmbulancia(Ambulancia amb)
	{
		this.ambulancia = amb;
	}
	
	public void setCantSolicitudes(int cant)
	{
		this.cantSolicitudes = cant;
	}
	
	public void setAccion(String accion)
	{
		this.accion = accion;
		//this.setChanged();
		//this.notifyObservers(this.accion);	
	}
	
	@Override
	public void run()
	{
		for(int i=0; i<this.cantSolicitudes ; i++)
		{
			Util.esperaRandom(3000);
			this.ambulancia.repararLaAmbulancia(this);
			Thread htemp = new Thread(new Temporizador(this.ambulancia));
			htemp.start();
		}
	}

}
