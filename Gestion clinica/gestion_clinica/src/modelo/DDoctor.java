package modelo;

public class DDoctor extends DecoratorPosgrado
{
	private IMedico encapsulado;
	
	protected DDoctor(IMedico encapsulado)
	{
		super();
		this.encapsulado = encapsulado;
	}
	
	@Override
	public double calculaSueldo()
	{
		double sueldo = this.encapsulado.calculaSueldo();
		sueldo += sueldo * 0.1;
		return sueldo;
	}
	
	public String datos()
	{
		return this.encapsulado.datos() + ", Posgrado: Doctor";
	}

	@Override
	public String toString()
	{
		return this.encapsulado.toString() + ", posgrado=doctor";
	}
	
	
	
}
