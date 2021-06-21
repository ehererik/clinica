package modelo;


/**
 * @author Agustin <br>
 *         Clase que se extiende de Medico que indica que la especialidad de
 *         este es pediatra
 */
public class Pediatra extends Medico
{


	protected Pediatra(String nombre, String apellido, String dni, String domicilio, String ciudad, String telefono, double sueldoBase)
	{
		super(nombre, apellido, dni, domicilio, ciudad, telefono, sueldoBase);
	}

	
	/**
	 * Metodo que devuelve un double que es el honorario basico del medico aumentado
	 * en un 7%.
	 */
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

	
	
	
}