package ar.edu.unlp.info.oo1.objetos_uno.ejercicio13;

public class Archivo {
	private String nombre;

	public Archivo(String nombre) {
		this.nombre = nombre;
	}
	
	public Archivo() {
		
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int tamanio() {
		return (this.getNombre().length());
	}
}
