package modelo;

import java.io.Serializable;

public class Prestacion implements IPrestacion, Serializable
{
	private static final long serialVersionUID = 79196461;
	private IPrestacion prestacion;
	private int cantidad;

	public Prestacion(IPrestacion prestacion, int cantidad)
	{
		this.prestacion = prestacion;
		this.cantidad = cantidad;
	}

	@Override
	public String getPrestacion()
	{
		return this.prestacion.getPrestacion();
	}

	@Override
	public double getValorUnitarioPrestacion()
	{
		return this.prestacion.getValorUnitarioPrestacion();
	}

	@Override
	public String getClavePrimariaString()
	{
		return this.prestacion.getClavePrimariaString();
	}

	public int getCantidad()
	{
		return this.cantidad;
	}

	public double getSubTotal()
	{
		return this.cantidad * this.prestacion.getValorUnitarioPrestacion();
	}
	
	public void mostrarPrestacion()
	{
		System.out.printf("%19s %17.2f %14d                 $ %8.2f %n",this.getClavePrimariaString(),this.getValorUnitarioPrestacion(),this.cantidad,this.getSubTotal());
	}
	
	
}
