package ar.edu.unlp.info.oo1.objetos_uno.ejercicio17;

import java.time.LocalDate;

public class Fisica extends Persona{
	private int dni;

	public Fisica(Numero numeroA, String nombre, String direccion, int dni) {
		super(numeroA, nombre, direccion);
		this.dni = dni;
	}
	
	public Factura facturarLlamadas(LocalDate fecha1, LocalDate fecha2) {
		double precio = this.getNumeroA().facturarLlamadas(fecha1, fecha2) /100 * 10;
		return new Factura(LocalDate.now(), fecha1, fecha2, this, precio);
	}

	public int getDni() {
		return dni;
	}
	
	
}
