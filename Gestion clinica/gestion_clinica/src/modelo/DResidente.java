package modelo;

public class DResidente extends DecoratorContratacion
{
	protected DResidente(IMedico encapsulado)
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
		return this.encapsulado.toString() + ", contratacion=residente]";
	}
	
	@Override
	public String getPrestacion()
	{
		return "Nombre del medico: " + this.getNombre();
	}

	@Override
	public double getValorUnitarioPrestacion()
	{
		double honorario = this.getHonorarioBasico();
		return honorario * INCREMENTO; 
	}

	@Override
	public String getClavePrimaria()
	{
		return this.getNombre();
	}

	@Override
	public String getNombre()
	{
		return this.encapsulado.getNombre();
	}

	@Override
	public String getDni()
	{
		return encapsulado.getDni();
	}
	
}
