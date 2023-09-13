package ar.edu.unlp.info.oo1.objetos_uno.ejercicio4;

public class Cuadrado implements forma{
	private double lado;

	public Cuadrado() {
		
	}

	public Cuadrado( double lado) {
		this.lado = lado;
	}

	public double getPerimetro() {
		return lado * 4;
	}
	
	public double getArea() {
		return lado * lado;
	}
	
	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}

	
}
