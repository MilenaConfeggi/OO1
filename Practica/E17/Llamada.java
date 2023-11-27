package ar.edu.unlp.info.oo1.objetos_uno.ejercicio17;

import java.time.LocalDate;

public abstract class Llamada {
	private LocalDate fecha;
	private double hora;
	private int duracion;
	private Numero telefonoRecibe;
	
	public Llamada(LocalDate fecha, double hora, int duracion, Numero telefonoRecibe) {
		this.fecha = fecha;
		this.hora = hora;
		this.duracion = duracion;
		this.telefonoRecibe = telefonoRecibe;
	}
	
	public abstract double precioLlamada();
	
	public boolean overlaps (LocalDate fecha1, LocalDate fecha2) {
		return !(fecha1.isBefore(this.fecha) || fecha2.isAfter(this.fecha));
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public double getHora() {
		return hora;
	}

	public int getDuracion() {
		return duracion;
	}

	public Numero getTelefonoRecibe() {
		return telefonoRecibe;
	}
	
	
}
