package ar.edu.unlp.info.oo1.objetos_uno;
import java.time.LocalDate;
import java.util.List;

public class Ticket {
	private LocalDate fecha = LocalDate.now();
	private int cantidadDeProductos;
	private double pesoTotal;
	private double precioTotal;
	private List<Producto> productos;
	
	public Ticket(int cantidadDeProductos, double pesoTotal, double precioTotal, List<Producto> productos) {
		this.fecha = LocalDate.now();
		this.cantidadDeProductos = cantidadDeProductos;
		this.pesoTotal = pesoTotal;
		this.precioTotal = precioTotal + impuesto(precioTotal);
		this.productos = productos;
	}

	private double impuesto(double precio) {
		return (precio/100*21);
	}
	
	
	public LocalDate getFecha() {
		return fecha;
	}

	public int getCantidadDeProductos() {
		return cantidadDeProductos;
	}

	public double getPesoTotal() {
		return pesoTotal;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

}
