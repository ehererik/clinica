package modelo;

import java.io.Serializable;

/**
 * @author Agustin <br>
 *         Clase abstracta decoradora que permite (en caso de ser necesario)
 *         agregarle un tipo de posgrado a un medico. Contiene un atributo
 *         "encapsulado" de tipo IMedico, que va a ser el medico a decorar.
 *         Implementa la interface IMedico.
 */
public abstract class DecoratorPosgrado implements IMedico, Serializable
{
	private static final long serialVersionUID = 1456789455;
	protected IMedico encapsulado;

	protected DecoratorPosgrado(IMedico encapsulado)
	{
		this.encapsulado = encapsulado;
	}

	@Override
	public String getNombre()
	{
		return this.encapsulado.getNombre();
	}

	@Override
	public String getDni()
	{
		return encapsulado.getDni();
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
