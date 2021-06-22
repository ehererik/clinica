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
		return "La ambulancia esta atendiendo a domicilio";
	}

	@Override
	public String trasladoALaClinica()
	{
		this.ambulancia.setEstado(new TrasladandoState(this.ambulancia));
		return "La ambulancia esta trasladando a la clinica";
	}

	@Override
	public String volverAClinica()
	{
		return "La ambulancia ya se encuentra en la clinica, por lo que ya estaba disponible";
	}

	@Override
	public String repararAmbulancia()
	{
		this.ambulancia.setEstado(new EnTallerState(this.ambulancia));
		return "La ambulancia esta yendo al taller para ser arreglada";
	}
}
