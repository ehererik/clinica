package modelo;

public abstract class Medico extends Persona implements IMedico
{
	protected double honorarioBasico;

	protected Medico(String nombre, String apellido, String dni, String domicilio, String ciudad, String telefono,
			double sueldoBase)
	{
		super(nombre, apellido, dni, domicilio, ciudad, telefono);
		this.honorarioBasico = sueldoBase;
	}

	public double getHonorarioBasico()
	{
		return this.honorarioBasico;
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
	public String getClavePrimariaString()
	{
		return null;
	}
}