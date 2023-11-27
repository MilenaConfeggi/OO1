package ar.edu.unlp.info.oo1.objetos_uno.ejercicio17;

import java.time.LocalDate;

public class Local extends Llamada {

	public Local(LocalDate fecha, double hora, int duracion, Numero telefonoRecibe) {
		super(fecha, hora, duracion, telefonoRecibe);
	}

	public double precioLlamada() {
		return (double)this.getDuracion();
	}
	
}
