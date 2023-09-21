package ar.edu.unlp.info.oo1.objetos_uno.ejercicio8;

import java.time.LocalDate;

public class Factura {
	private double montoEnergiaActiva;
	private double descuento;
	private LocalDate fecha;
	private Usuario user;
	
	
	public Factura() {
	}

	public Factura(double montoEnergiaActiva, double descuento, Usuario usuario) {
		this.montoEnergiaActiva = montoEnergiaActiva;
		this.descuento = descuento;
		this.fecha = LocalDate.now();
		this.user = usuario;
	}
	
	public double montoTotal() {
		return (this.montoEnergiaActiva - (this.montoEnergiaActiva / 100) * this.descuento);
	}

	public double getMontoEnergiaActiva() {
		return montoEnergiaActiva;
	}

	public double getDescuento() {
		return descuento;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public Usuario getUser() {
		return user;
	}
		
}
