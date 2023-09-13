package ar.edu.unlp.info.oo1.objetos_uno.ejercicio4;

public class Circulo extends forma{
	private double radio;
	private double diametro;
	
	public Circulo() {
		
	}

	public Circulo(double radio, double diametro) {
		this.radio = radio;
		this.diametro = radio * 2;
	}
	
	public double getPerimetro() {
		return (this.diametro * Math.PI);
	}
	
	public double getArea() {
		return ((radio*radio)*Math.PI);
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	public double getDiametro() {
		return diametro;
	}

	public void setDiametro(double diametro) {
		this.diametro = diametro;
	}
	
	
}
