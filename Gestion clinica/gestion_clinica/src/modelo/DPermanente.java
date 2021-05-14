package modelo;

/**
 * @author Agustin <br>
 *         Clase que se extiende de "DecoratorContratacion" que permite que su
 *         atributo encapsulado de tipo "IMedico" tenga una contratacion de tipo
 *         plantel permanente
 *
 */
public class DPermanente extends DecoratorContratacion
{
	protected DPermanente(IMedico encapsulado)
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
		return this.encapsulado.toString() + ", contratacion=plantel permanente]";
	}

}
