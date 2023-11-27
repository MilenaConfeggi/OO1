package ar.edu.unlp.info.oo1.objetos_uno.ejercicio19;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Persona {
	private String nombre;
	private String direccion;
	private List<Producto> productos;		
	
	public Persona(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.productos = new ArrayList<Producto>();
	}
	
	public void aniadirProducto(Producto producto) {
		this.productos.add(producto);
	}
	
	public List<Producto> buscarProducto(String nombre){
		return this.productos.stream().filter(pro -> pro.getNombre().equals(nombre)).collect(Collectors.toList());
	}
	
	public void crearPedido(Producto p, int cant, Pago pago, Envio envio) {
		Pedido pedido = new Pedido(this, p, cant, pago, envio);
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public List<Producto> getProductos() {
		return productos;
	}
	
	
}
