package modelo;

public class Pediatra extends Medico
{

	protected Pediatra(String nombre, String apellido, String dni, String domicilio, String ciudad, String telefono, double sueldoBase)
	{
		super(nombre, apellido, dni, domicilio, ciudad, telefono, sueldoBase);
	}

	@Override
	public double getHonorarioBasico()
	{
		double sueldo = this.honorarioBasico;
		sueldo += sueldo * 0.07;	
		return sueldo;
	}

	@Override
	public String toString()
	{
		return "Pediatra [sueldoBase=" + this.getHonorarioBasico() + ", nombre=" + this.getNombre() + ", apellido=" + this.getApellido() + ", dni=" + this.getDni()
				+ ", domicilio=" + this.getDomicilio() + ", ciudad=" + this.getCiudad() + ", telefono=" + this.getTelefono() ;
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