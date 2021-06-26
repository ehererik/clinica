package modelo;

/**
 * @author Agustin <br>
 *         Clase que se extiende de "DecoratorPosgrado" que permite que su
 *         atributo encapsulado de tipo "IMedico" tenga un posgrado de tipo
 *         Doctor
 *
 */
public class DDoctor extends DecoratorPosgrado
{
	private static final long serialVersionUID = 332999455;
	protected DDoctor(IMedico encapsulado)
	{
		super(encapsulado);
	}

	
	/**
	 * Metodo que devuelve en un double, el honorario de su atributo encapsulado,
	 * incrementado en un 10%
	 */
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
		return this.encapsulado.toString() + ", posgrado=doctor";
	}

}
