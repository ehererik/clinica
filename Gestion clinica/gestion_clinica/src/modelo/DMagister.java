package modelo;

public class DMagister extends DecoratorPosgrado
{
	protected DMagister(IMedico encapsulado)
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
		return this.encapsulado.datos() + ", Posgrado: Magister";
	}

	@Override
	public String toString()
	{
		return this.encapsulado.toString() + ", posgrado=magister";
	}
}