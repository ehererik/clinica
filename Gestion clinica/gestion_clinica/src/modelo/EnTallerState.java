package modelo;

public class EnTallerState implements IState
{
	private Ambulancia ambulancia;
	
	public EnTallerState(Ambulancia ambulancia)
	{
		this.ambulancia = ambulancia;
	}

	@Override
	public String atencionDomicilio()
	{
		return "No se puede realizar la atencion a domicilio, se esta reparando la ambulancia";
	}

	@Override
	public String trasladoALaClinica()
	{
		return "No se puede realizar el traslado a la clinica, se esta reparando la ambulancia";
	}

	@Override
	public void volverAClinica()
	{
		this.ambulancia.setEstado(new RegresandoTallerState(this.ambulancia));
	}

	@Override
	public String repararAmbulancia()
	{
		return null;
	}
}
