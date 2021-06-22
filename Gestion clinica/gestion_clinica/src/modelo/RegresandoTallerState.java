package modelo;

public class RegresandoTallerState implements IState
{
	private Ambulancia ambulancia;
	
	public RegresandoTallerState(Ambulancia ambulancia)
	{
		this.ambulancia = ambulancia;
	}

	@Override
	public String atencionDomicilio()
	{
		return "No se puede realizar la atencion a domicilio, se esta regresando del taller";
	}

	@Override
	public String trasladoALaClinica()
	{
		return "No se puede realizar el traslado a la clinica, se esta regresando del taller";
	}

	@Override
	public String volverAClinica()
	{
		this.ambulancia.setEstado(new DisponibleState(this.ambulancia));
		return "La ambulancia se encuentra disponible en la clinica";
	}

	@Override
	public String repararAmbulancia()
	{
		return "No se puede reparar la ambulancia, se esta regresando del taller";
	}
}
