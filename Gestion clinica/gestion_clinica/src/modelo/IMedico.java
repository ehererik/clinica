package modelo;

public interface IMedico
{
	static final double INCREMENTO = 1.2;

	public abstract double getHonorarioBasico();

	public abstract String toString();

	public abstract String getNombre();

	public abstract String getPrestacion(); // retorna un string de la forma TIPO DE PRESTACION + CLAVE PRIMARIA. Por ej.
									// tipo de prestacion:Medico y clave:Juan Gomez ---> Devuelve Medico: Juan Gomez

	public abstract double getValorUnitarioPrestacion();

	public abstract String getClavePrimaria(); // retorna el valor de la prestacion -----> nombre del medico, numero de
										// habitacion, etc
}
