package modelo;

public abstract class Habitacion implements IPrestacion
{
	double costoBase;
	private int numHabitacion;
	private static int cantHabitaciones = 0;

	public Habitacion(double costoBase)
	{
		this.costoBase = costoBase;
		this.numHabitacion = ++Habitacion.cantHabitaciones;
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
	public String getClavePrimariaString()
	{
		String clave = Integer.toString(this.numHabitacion);
		return "Habitacion N� " + clave;
	}

	private double costoHabitacion()
	{
		return this.costoBase;
	}

}