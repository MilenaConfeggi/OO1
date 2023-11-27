package ar.edu.unlp.info.oo1.objetos_uno.ejercicio17;

import java.time.LocalDate;

public class Internacional extends Llamada{
	private String paisO;
	private String paisD;
	
	
	public Internacional(LocalDate fecha, double hora, int duracion, Numero telefonoRecibe, String paisO, String paisD) {
		super(fecha, hora, duracion, telefonoRecibe);
		this.paisO = paisO;
		this.paisD = paisD;
	}
	
	public double precioLlamada() {
		if (this.getHora() >= 8.0 && this.getHora()<= 20.0) 
			return this.getDuracion() * 4;
		else
			return this.getDuracion() * 3;
	}

	public String getPaisO() {
		return paisO;
	}

	public String getPaisD() {
		return paisD;
	}
	
	
}
