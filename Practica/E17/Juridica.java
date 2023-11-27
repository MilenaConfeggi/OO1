package ar.edu.unlp.info.oo1.objetos_uno.ejercicio17;

public class Juridica extends Persona{
	private int cuit;

	public Juridica(Numero numeroA, String nombre, String direccion, int cuit) {
		super(numeroA, nombre, direccion);
		this.cuit = cuit;
	}

	public int getCuit() {
		return cuit;
	}
	
	
}
