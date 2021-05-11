package modelo;

public class DMagister extends DecoratorPosgrado
{
	protected DMagister(IMedico encapsulado)
	{
		super(encapsulado);
	}

	@Override
	public double getHonorarioBasico()
	{
		double sueldo = this.encapsulado.getHonorarioBasico();
		sueldo += sueldo * 0.05;
		return sueldo;
	}

	@Override
	public String toString()
	{
		return this.encapsulado.toString() + ", posgrado=magister";
	}

	@Override
	public String getNombre()
	{
		return this.encapsulado.getNombre();
	}

	@Override
	public String getPrestacion()
	{
		return null;
	}

	@Override
	public double getValorUnitarioPrestacion()
	{
		return 0;
	}

	@Override
	public String getClavePrimaria()
	{
		return null;
	}
}