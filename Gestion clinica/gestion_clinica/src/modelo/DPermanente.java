package modelo;

public class DPermanente extends DecoratorContratacion
{
	private IMedico encapsulado;
	
	protected DPermanente(IMedico encapsulado)
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
		return this.encapsulado.datos() + ", Contratacion: Plantel permanente";
	}
	
	@Override
	public String toString()
	{
		return this.encapsulado.toString() + ", contratacion=plantel permanente]";
	}
}
