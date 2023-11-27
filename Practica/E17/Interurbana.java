package ar.edu.unlp.info.oo1.objetos_uno.ejercicio17;

import java.time.LocalDate;

public class Interurbana extends Llamada{
	private int distancia;

	public Interurbana(LocalDate fecha, double hora, int duracion, Numero telefonoRecibe, int distancia) {
		super(fecha, hora, duracion, telefonoRecibe);
		this.distancia = distancia;
	}
	
	public double precioLlamada() {
		double cant = 5.0;
		if (this.distancia < 100) {
			cant+= this.getDuracion() * 2.0;
		}
		else { 
			if (this.distancia >= 100 && this.distancia < 500) {
				cant+= this.getDuracion() * 2.5;
			}
			else
			   cant+= this.getDuracion()* 3.0;
		}
		return cant;
	}

	public int getDistancia() {
		return distancia;
	}
	
	
}
