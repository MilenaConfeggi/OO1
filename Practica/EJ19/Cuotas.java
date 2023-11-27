package ar.edu.unlp.info.oo1.objetos_uno.ejercicio19;

public class Cuotas implements Pago{
	
	public double calcularPrecio(double p) {
		return p + (p / 100 * 20);
	}
}
