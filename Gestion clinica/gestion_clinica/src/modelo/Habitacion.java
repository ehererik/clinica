package modelo;


public class Habitacion implements IPrestacion
{
	double costoBase;
	private int numHabitacion;

	public Habitacion(double costoBase)
	{
		this.costoBase = costoBase;
	}

	public int getNumHabitacion()
	{
		return this.numHabitacion;
	}

	@Override
	public String getPrestacion()
	{
		return "Habitacion: " + this.numHabitacion;
	}

	@Override
	public double getValorUnitarioPrestacion()
	{
		return this.costoHabitacion();
	}

	@Override
	public String getClavePrimaria()
	{
		String clave = Integer.toString(this.numHabitacion);
		return clave;
	}

	private double costoHabitacion()
	{
		return this.costoBase;
	}

}