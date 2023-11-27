package ar.edu.unlp.info.oo1.objetos_uno.ejercicio17;

import java.time.LocalDate;

public class Factura {
	private LocalDate fechafac;
	private LocalDate fechaI;
	private LocalDate fechaT;
	private Persona cliente;
	private double monto;
	
	public Factura(LocalDate fechafac, LocalDate fechaI, LocalDate fechaT, Persona cliente, double monto) {
		super();
		this.fechafac = fechafac;
		this.fechaI = fechaI;
		this.fechaT = fechaT;
		this.cliente = cliente;
		this.monto = monto;
	}

	public LocalDate getFechafac() {
		return fechafac;
	}

	public LocalDate getFechaI() {
		return fechaI;
	}

	public LocalDate getFechaT() {
		return fechaT;
	}

	public Persona getCliente() {
		return cliente;
	}

	public double getMonto() {
		return monto;
	}
	
	
}
