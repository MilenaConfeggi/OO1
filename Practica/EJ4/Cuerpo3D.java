package ar.edu.unlp.info.oo1.objetos_uno.ejercicio4;

public class Cuerpo3D {
	private double altura;
	private forma caraBasal;
	
	public Cuerpo3D() {
		
	}
	
	public Cuerpo3D(double altura) {
		this.altura = altura;
	}
	
	public double getVolumen() {
		return (this.caraBasal.getArea() * altura);
	}
	
	public double getSuperficieExterior() {
		return (2*this.caraBasal.getArea() + this.caraBasal.getPerimetro()*altura);
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public void setCaraBasal(forma caraBasal) {
		this.caraBasal = caraBasal;
	}
	
	
}
