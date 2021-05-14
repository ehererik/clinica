package modelo;

public abstract class DecoratorContratacion implements IMedico, IPrestacion
{
	protected IMedico encapsulado;

	protected DecoratorContratacion(IMedico encapsulado)
	{
		this.encapsulado = encapsulado;
	}

	
	
}
