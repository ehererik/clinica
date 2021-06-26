package modelo;


/**
 * @author Agustin <br>
 *         Clase que se extiende de "DecoratorContratacion" que permite que su
 *         atributo encapsulado de tipo "IMedico" tenga una contratacion de tipo
 *         residente (temporario)
 *
 */
public class DResidente extends DecoratorContratacion
{
	private static final long serialVersionUID = 1833499455;
	protected DResidente(IMedico encapsulado)
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
		return this.encapsulado.toString() + ", contratacion=residente]";
	}
	
}
