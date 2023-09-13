package ar.edu.unlp.info.oo1.objetos_uno;

import java.util.ArrayList;
import java.util.List;



public class Balanza {
	private int cantidadDeProductos;
	private double precioTotal;
	private double pesoTotal;
	private List<Producto> productos;
	
	
	
	public Balanza(int cantidadDeProductos, double precioTotal, double pesoTotal) {
		super();
		this.cantidadDeProductos = cantidadDeProductos;
		this.precioTotal = precioTotal;
		this.pesoTotal = pesoTotal;
		this.productos = new ArrayList<Producto>();
	}

	public void ponerEnCero() {
		this.pesoTotal = 0;
		productos.clear();
	}
	
	public void agregarProducto (Producto producto) {
		this.cantidadDeProductos++;
		this.precioTotal += producto.getPrecio();
		this.pesoTotal += producto.getPeso();
		this.productos.add(producto);
	}
	
	public Ticket emitirTicket() {
		Ticket ticket = new Ticket(this.cantidadDeProductos, this.precioTotal, this.pesoTotal, this.productos);
		return ticket;
	}
	
	public List<Producto> getProductos(){
		if (this.productos.isEmpty())
			return null;
		else
			return this.productos;
	}
}
