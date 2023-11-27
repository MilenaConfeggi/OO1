package ar.edu.unlp.info.oo1.objetos_uno.ejercicio17;

import java.time.LocalDate;

public abstract class Persona {
	private Numero numeroA;
	private String nombre;
	private String direccion;
	
	public Persona(Numero numeroA, String nombre, String direccion) {
		this.numeroA = numeroA;
		this.nombre = nombre;
		this.direccion = direccion;
	}
	
	public Factura facturarLlamadas(LocalDate fecha1, LocalDate fecha2) {
		double precio = this.numeroA.facturarLlamadas(fecha1, fecha2);
		return new Factura(LocalDate.now(), fecha1, fecha2, this, precio);
	}
	
	public void registrarLlamadaLocal(LocalDate fecha, int hora, int duracion, Numero num1, Numero num2) {
		if (this.numeroA.equals(num1))
			this.numeroA.registrarLlamadaLocal(fecha, hora, duracion, num2);
		else
			if (this.numeroA.equals(num2))
				this.numeroA.registrarLlamadaLocal(fecha, hora, duracion, num1);
	}
	
	public void registrarLlamadaInterurbana(LocalDate fecha, int hora, int duracion, Numero num1, Numero num2, int distancia) {
		if (this.numeroA.equals(num1))
			this.numeroA.registrarLlamadaInterurbana(fecha, hora, duracion, num2, distancia);
		else
			if (this.numeroA.equals(num2))
				this.numeroA.registrarLlamadaInterurbana(fecha, hora, duracion, num1, distancia);
	}
	
	public void registrarLlamadaInternacional(LocalDate fecha, int hora, int duracion, Numero num1, Numero num2, String pais1, String pais2) {
		if (this.numeroA.equals(num1))
			this.numeroA.registrarLlamadaInternacional(fecha, hora, duracion, num2, pais1, pais2);
		else
			if (this.numeroA.equals(num2))
				this.numeroA.registrarLlamadaInternacional(fecha, hora, duracion, num1, pais1, pais2);
	}
	
	public boolean esIgual(Numero num1, Numero num2) {
		return this.numeroA.equals(num2) || this.numeroA.equals(num1);
	}

	public Numero getNumeroA() {
		return numeroA;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}
	
}
