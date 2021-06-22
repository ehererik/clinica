package modelo;

public class TrasladandoState implements IState
{
	private Ambulancia ambulancia;
	
	public TrasladandoState(Ambulancia ambulancia)
	{
		this.ambulancia = ambulancia;
	}

	@Override
	public String atencionDomicilio()
	{
		return "No se puede realizar la atencion a domicilio, se esta trasladando a otro paciente al hospital";
	}

	@Override
	public String trasladoALaClinica()
	{
		return "No se puede realizar el traslado del domicilio, se esta trasladando otro paciente al hospital";
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
		return "No se puede reparar la ambulancia, se esta trasladando un paciente al hospital";
	}
}
