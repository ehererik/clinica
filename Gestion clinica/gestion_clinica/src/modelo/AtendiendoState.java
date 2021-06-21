package modelo;

public class AtendiendoState implements IState
{
	private Ambulancia ambulancia;
	
	public AtendiendoState(Ambulancia ambulancia)
	{
		this.ambulancia = ambulancia;
	}

	@Override
	public String atencionDomicilio()
	{
		return "No se puede atender al domicilio, ya se esta atendiendo a otro paciente en su domicilio";
	}

	@Override
	public String trasladoALaClinica()
	{
		return "No se puede trasladar a la clinica, se esta atendiendo a un paciente en su domicilio";
	}

	@Override
	public void volverAClinica()
	{
		this.ambulancia.setEstado(new TrasladandoState(this.ambulancia));
	}

	@Override
	public String repararAmbulancia()
	{
		return "No se puede reparar la ambulancia, se esta atendiendo a un paciente en su domicilio";
	}
}
