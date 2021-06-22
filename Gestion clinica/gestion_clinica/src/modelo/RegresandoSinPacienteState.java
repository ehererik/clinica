package modelo;

public class RegresandoSinPacienteState implements IState
{
	private Ambulancia ambulancia;
	
	public RegresandoSinPacienteState(Ambulancia ambulancia)
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
		return "No se puede trasladar al paciente a clinica, la ambulancia esta regresando de una atencion domiciliaria";
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
		return "No se puede reparar la ambulancia, la ambulancia esta regresando de una atencion domiciliaria";
	}
}
