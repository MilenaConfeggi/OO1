package ar.edu.unlp.info.oo1.objetos_uno.ejercicio19;

public class Pedido {
	private Persona cliente;
	private Producto producto;
	private int cantidad;
	private Pago forma;
	private Envio envio;
	
	
	public Pedido(Persona cliente, Producto producto, int cantidad, Pago forma, Envio envio) {
		this.cliente = cliente;
		this.producto = producto;
		this.cantidad = cantidad;
		this.forma = forma;
		this.envio = envio;
	}

	public double calcularMonto() {
		return forma.calcularPrecio(this.getCantidad() * this.getProducto().getPrecio()) + envio.costoEnvio(this.cliente.getDireccion(), this.producto.obtenerDireccionVendedor());
	}
	
	public Persona getCliente() {
		return cliente;
	}
	public Producto getProducto() {
		return producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	
	
}
