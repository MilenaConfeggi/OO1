package ar.edu.unlp.info.oo1.objetos_uno.ejercicio19;

import java.util.ArrayList;
import java.util.List;

public class Mercado {
	private List<Persona> clientes;
	private List<Persona> vendedores;
	
	public Mercado(List<Persona> clientes, List<Persona> vendedores) {
		this.clientes = clientes;
		this.vendedores = vendedores;
	}
	
	public Persona registrarVendedor(String nombre, String direc) {
		Persona vendedor = new Persona(nombre, direc);
		this.vendedores.add(vendedor);
		return vendedor;
	}
	
	public Persona buscarVendedor(String nombre) {
		return this.vendedores.stream().filter(ven -> ven.getNombre().equals(nombre)).findFirst().orElse(null);	
	}
	
	public Persona registrarCliente(String nombre, String direc) {
		Persona cliente = new Persona(nombre, direc);
		this.clientes.add(cliente);
		return cliente;
	}
	
	public Persona buscarCliente(String nombre) {
		return this.clientes.stream().filter(cli -> cli.getNombre().equals(nombre)).findFirst().orElse(null);	
	}
	
	public Producto ponerProducto(String nombre, String desc, double precio, int cant, Persona vendedor) {
		Producto producto = new Producto(nombre, desc, precio, cant, vendedor);
		vendedor.aniadirProducto(producto);
		return producto;
	}
	
	public List<Producto> buscarProducto(String nombre){
		List<Producto> l = new ArrayList<Producto>();
		this.vendedores.stream().forEach(pro -> l.addAll(pro.buscarProducto(nombre)));
		return l;
	}
	
	public double calcularCostoPedido(Pedido pedido) {
		return pedido.calcularMonto();
	}
}
