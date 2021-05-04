package modelo;

public class DMagister extends DecoratorPosgrado
{
	private IMedico encapsulado;
	
	protected DMagister(IMedico encapsulado)
	{
		super();
		this.encapsulado = encapsulado;
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