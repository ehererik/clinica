package modelo;

public class Cirujano extends Medico
{

	protected Cirujano(String nombre, String apellido, String dni, String domicilio, String ciudad, String telefono, double sueldoBase)
	{
		super(nombre, apellido, dni, domicilio, ciudad, telefono, sueldoBase);
	}

	@Override
	public double calculaSueldo()
	{
		double sueldo = this.honorarioBasico;
		sueldo += sueldo * 0.1;
		return sueldo;
	}

	public String datos()
	{
		return super.datos() + ", Especialidad: Cirujano";
	}

	@Override
	public String toString()
	{
		return "Cirujano [sueldoBase=" + this.getHonorarioBasico() + ", nombre=" + this.getNombre() + ", apellido=" + this.getApellido() + ", dni=" + this.getDni()
				+ ", domicilio=" + this.getDomicilio() + ", ciudad=" + this.getCiudad() + ", telefono=" + this.getTelefono();
	}
	
}
