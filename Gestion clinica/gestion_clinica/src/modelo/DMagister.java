package modelo;

/**
 * @author Agustin <br>
 *         Clase que se extiende de "DecoratorPosgrado" que permite que su
 *         atributo encapsulado de tipo "IMedico" tenga un posgrado de
 *         tipo Magister
 *
 */
public class DMagister extends DecoratorPosgrado
{
	private static final long serialVersionUID = 1843529455;
	protected DMagister(IMedico encapsulado)
	{
		super(encapsulado);
	}

	
	
	/**
	 * Metodo que devuelve en un double, el honorario de su atributo encapsulado,
	 * incrementado en un 5%
	 */
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

}