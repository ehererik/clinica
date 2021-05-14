package modelo;
public class Prestacion implements IPrestacion{

	private IPrestacion prestacion;
	private int cantidad;
	
	public Prestacion(IPrestacion prestacion, int cantidad) {
		this.prestacion = prestacion;
		this.cantidad = cantidad;
	}

	@Override
	public String getPrestacion() {
		return this.prestacion.getPrestacion();
	}

	@Override
	public double getValorUnitarioPrestacion() {
		return this.prestacion.getValorUnitarioPrestacion();
	}


	@Override
	public String getClavePrimaria() {
		return this.prestacion.getClavePrimaria();
	}
	
	
	public int getCantidad() {
		return this.cantidad;
	}

	public double getSubTotal() {	
		return this.cantidad*this.prestacion.getValorUnitarioPrestacion();
	}

	
	
	@Override
	public String toString() {
		return this.getClavePrimaria()+"     "+this.getValorUnitarioPrestacion()+"        "+this.cantidad+"        $"+this.getSubTotal();
	}
	
	
}
