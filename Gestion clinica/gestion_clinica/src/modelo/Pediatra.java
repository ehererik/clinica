package modelo;

public class Pediatra extends Medico
{

	protected Pediatra(String nombre, String apellido, String dni, String domicilio, String ciudad, String telefono, double sueldoBase)
	{
		super(nombre, apellido, dni, domicilio, ciudad, telefono, sueldoBase);
	}

	@Override
	public double calculaSueldo()
	{
		double sueldo = this.honorarioBasico;
		sueldo += sueldo * 0.07;	
		return sueldo;
	}
	
	public String datos()
	{
		return super.datos() + ", Especialidad: Pediatra";
	}

	@Override
	public String toString()
	{
		return "Pediatra [sueldoBase=" + this.getHonorarioBasico() + ", nombre=" + this.getNombre() + ", apellido=" + this.getApellido() + ", dni=" + this.getDni()
				+ ", domicilio=" + this.getDomicilio() + ", ciudad=" + this.getCiudad() + ", telefono=" + this.getTelefono() ;
	}
	
	
}