package ar.edu.unlp.info.oo1.objetos_uno.ejercicio3;

public class Item {
	private String detalle;
	private int cantidad;
	private double costoUnitario;
	
	public Item(String detalle, int cantidad, double costoUnitarios) {
		super();
		this.detalle = detalle;
		this.cantidad = cantidad;
		this.costoUnitario = costoUnitarios;
	}
	
	public double costo () {
		return this.costoUnitario * this.cantidad;
	}

	public double getCostoUnitario() {
		return costoUnitario;
	}

	public String getDetalle() {
		return this.detalle;
	}
	
}
