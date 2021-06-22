package modelo;

public class Ambulancia implements IState
{
	private IState estado;
	private static Ambulancia Instance; 
	private boolean disponible;
	private String accion;
	
	public static Ambulancia getInstance()
	{
		if(Ambulancia.Instance == null)
			Ambulancia.Instance = new Ambulancia();
		return Ambulancia.Instance;
	}
	
	private Ambulancia()
	{
		this.setEstado(new DisponibleState(this));
		this.disponible = true;
		this.accion = "La ambulancia esta en la clinica preparada para iniciar la simulacion";
		//this.setChanged();
		//this.notifyObservers(this.accion);
	}
	
	public boolean getDisponible()
	{
		return this.disponible;
	}
	
	public IState getEstado()
	{
		return estado;
	}

	protected void setEstado(IState estado)
	{
		this.estado = estado;
	}

	@Override
	public String atencionDomicilio()
	{
		return this.estado.atencionDomicilio();
	}

	@Override
	public String trasladoALaClinica()
	{
		return this.estado.trasladoALaClinica();
	}

	@Override
	public String volverAClinica()
	{
		return this.estado.volverAClinica();
	}

	@Override
	public String repararAmbulancia()
	{
		return this.estado.repararAmbulancia();
	}
	
	protected void setDisponible()
	{
		this.disponible = true;
	}
	
	public synchronized void ambulanciaDisponible()
	{
		this.accion = this.volverAClinica();
		//this.setChanged();
		//this.notifyObservers(this.accion);
		this.disponible = true;
		notifyAll();
	}
	
	public synchronized void volverALAClinica()
	{
		this.accion = this.volverAClinica();
		//this.setChanged();
		//this.notifyObservers(this.accion);
	}
	
	public synchronized void solicitarAtecionDomicilio(Asociado asociado)
	{
		while(!disponible)
		{
			try
			{	
				asociado.setAccion(asociado.getNombre() + " " + asociado.getApellido() + " solicita atencion a domicilio pero la ambulancia no esta disponible, debe esperar");
				wait();
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		this.disponible = false;
		this.accion = this.atencionDomicilio();
		//this.setChanged();
		//this.notifyObservers(this.accion);
	}
	
	public synchronized void trasladoClinica(Asociado asociado)
	{
		while(!disponible)
		{
			try
			{
				asociado.setAccion(asociado.getNombre() + " " + asociado.getApellido() + " solicita traslado a la clinica pero la ambulancia no esta disponible, debe esperar");
				wait();
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		this.disponible = false;
		this.accion = this.trasladoALaClinica();
		//this.setChanged();
		//this.notifyObservers(this.accion);
	}
	
	public synchronized void repararLaAmbulancia(Operario op)
	{
		while(!disponible)
		{
			try
			{
				op.setAccion("El operario quiere llevar a reparar la ambulancia pero esta no esta disponible, debe esperar");
				wait();
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		this.disponible = false;
		this.accion = this.repararAmbulancia();
		//this.setChanged();
		//this.notifyObservers(this.accion);
	}
	
}

