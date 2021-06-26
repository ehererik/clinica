package modelo;

import java.io.Serializable;
import java.util.Random;

import util.Util;

public class Asociado extends Persona implements Runnable, Serializable
{
	private static final long serialVersionUID = 1324538455;
	private transient Ambulancia ambulancia;
	private transient int solicitud;
	private int cantSolicitudes = 4;
	private String accion;
	
	public Asociado(String nombre, String apellido, String dni, String domicilio, String telefono)
	{
		super(nombre,apellido,dni,domicilio,telefono);
		this.accion = "El asociado " + this.getNombre() + " " + this.getApellido() + " se encuentra en su domicilio";
		//this.setChanged();
		//this.notifyObservers(this.accion);
	}
	
	public String getAccion()
	{
		return this.accion;
	}
	
	public Ambulancia getAmbulancia()
	{
		return this.ambulancia;
	}
	
	public void setAmbulancia(Ambulancia amb)
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
	public String toString()
	{
		return "Asociado [" + this.getNombre() + "]";
	}

	@Override
	public void run()
	{
		
		for(int i=0; i<this.cantSolicitudes ; i++)
		{
			Random r = new Random();
			solicitud = r.nextInt(2);
			if(solicitud == 1)
			{
				Util.esperaRandom(3000);
				this.ambulancia.solicitarAtecionDomicilio(this);
				this.accion = "El asociado " + this.getNombre() + " " + this.getApellido() + " esta siendo atendido en su domicilio";
				//this.setChanged();
				//this.notifyObservers(this.accion);
				Thread htemp = new Thread(new Temporizador(this.ambulancia));
				htemp.start();
			}
			else
			{
				Util.esperaRandom(3000);
				this.ambulancia.trasladoClinica(this);
				this.accion = "El asociado " + this.getNombre() + " " + this.getApellido() + " esta siendo trasladado a la clinica";
				//this.setChanged();
				//this.notifyObservers(this.accion);
				Thread htemp = new Thread(new Temporizador(this.ambulancia));
				htemp.start();
			}
			Util.esperaRandom(10000);
		}
		this.accion = "El asociado " + this.getNombre() + " " + this.getApellido() + " se encuentra en su domicilio";
	}
	
}
