package modelo;

public abstract class DecoratorPosgrado implements IMedico
{
	protected IMedico encapsulado;

	protected DecoratorPosgrado(IMedico encapsulado)
	{
		this.encapsulado = encapsulado;
	}
}
