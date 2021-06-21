package modelo;

public class Ambulancia
{
	private IState estado;
	
	public Ambulancia()
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
	
	
}
