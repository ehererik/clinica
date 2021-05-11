package modelo;

public abstract class DecoratorContratacion implements IMedico
{
	protected IMedico encapsulado;

	protected DecoratorContratacion(IMedico encapsulado)
	{
		this.encapsulado = encapsulado;
	}

}
