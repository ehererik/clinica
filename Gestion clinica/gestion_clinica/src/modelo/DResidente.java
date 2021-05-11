package modelo;

public class DResidente extends DecoratorContratacion
{
	protected DResidente(IMedico encapsulado)
	{
		super(encapsulado);
	}

	@Override
	public double calculaSueldo()
	{
		double sueldo = this.encapsulado.calculaSueldo();
		sueldo += sueldo * 0.05;
		return sueldo;
	}

	public String datos()
	{
		return this.encapsulado.datos() + ", Contratacion: Residente";
	}

	@Override
	public String toString()
	{
		return this.encapsulado.toString() + ", contratacion=residente]";
	}
}
