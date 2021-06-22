package modelo;

public class Ambulancia implements IState
{
	private IState estado;
	private static Ambulancia Instance; 
	
	public static Ambulancia getInstance()
	{
		if(Ambulancia.Instance == null)
			Ambulancia.Instance = new Ambulancia();
		return Ambulancia.Instance;
	}
	
	private Ambulancia()
	{
		this.setEstado(new DisponibleState(this));
	}

	public IState getEstado()
	{
		return estado;
	}

	public void setEstado(IState estado)
	{
		this.estado = estado;
	}
	
	public synchronized void solicitarAtecionDomicilio()
	{
		
		try
		{
			wait();
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
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
	public void volverAClinica()
	{
		this.estado.volverAClinica();
	}

	@Override
	public String repararAmbulancia()
	{
		return this.estado.repararAmbulancia();
	}
	
	
	
	
}
