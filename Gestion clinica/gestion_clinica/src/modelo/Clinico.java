package modelo;

public class Clinico extends Medico
{

	protected Clinico(String nombre, String apellido, String dni, String domicilio, String ciudad, String telefono, double sueldoBase)
	{
		super(nombre, apellido, dni, domicilio, ciudad, telefono, sueldoBase);
	}

	@Override
	public double getHonorarioBasico()
	{
		double sueldo = this.honorarioBasico;
		sueldo += sueldo * 0.05;	
		return sueldo;
	}

	@Override
	public String toString()
	{
		return "Clinico [sueldoBase=" + this.getHonorarioBasico() + ", nombre=" + this.getNombre() + ", apellido=" + this.getApellido() + ", dni=" + this.getDni()
				+ ", domicilio=" + this.getDni() + ", ciudad=" + this.getCiudad() + ", telefono=" + this.getTelefono();
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