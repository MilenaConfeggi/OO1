package ar.edu.unlp.info.oo1.objetos_uno.ejercicio19;

public class Producto {
	private Persona vendedor;
	private String nombre;
	private String descripcion;
	private double precio;
	private int cantUnidades;
	
	public Producto(String nombre, String desc, double precio, int cantUnidades, Persona vendedor) {
		this.nombre = nombre;
		this.descripcion = desc;
		this.precio = precio;
		this.cantUnidades = cantUnidades;
		this.vendedor = vendedor;
	}
	
	public boolean hayStockSuficiente(int cant) {
		return cant <= this.getCantUnidades();
	}
	
	public void actualizarStock(int cant) {
		this.cantUnidades =- cant;
	}
	
	public String obtenerDireccionVendedor() {
		return this.getVendedor().getDireccion();
	}

	public Persona getVendedor() {
		return vendedor;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public int getCantUnidades() {
		return cantUnidades;
	}
	
	
}
