package modelo;

public class DisponibleState implements IState
{
	private Ambulancia ambulancia;
	
	public DisponibleState(Ambulancia ambulancia)
	{
		this.ambulancia = ambulancia;
	}

	@Override
	public String atencionDomicilio()
	{
		this.ambulancia.setEstado(new AtendiendoState(this.ambulancia));
		return null;
	}

	@Override
	public String trasladoALaClinica()
	{
		this.ambulancia.setEstado(new RegresandoSinPacienteState(this.ambulancia));
		return null;
	}

	@Override
	public void volverAClinica(){}

	@Override
	public String repararAmbulancia()
	{
		this.ambulancia.setEstado(new EnTallerState(this.ambulancia));
		return null;
	}
}
