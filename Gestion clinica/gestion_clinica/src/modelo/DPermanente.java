package modelo;

public class DPermanente extends DecoratorContratacion
{
	protected DPermanente(IMedico encapsulado)
	{
		super(encapsulado);
	}

	@Override
	public double getHonorarioBasico()
	{
		double sueldo = this.encapsulado.getHonorarioBasico();
		sueldo += sueldo * 0.1;
		return sueldo;
	}

	@Override
	public String toString()
	{
		return this.encapsulado.toString() + ", contratacion=plantel permanente]";
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
		return honorario * 1.2; // hay que agregar la constante
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
