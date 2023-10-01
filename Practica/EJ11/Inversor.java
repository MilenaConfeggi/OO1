package ar.edu.unlp.info.oo1.objetos_uno.ejercicio11;

import java.util.ArrayList;
import java.util.List;

public class Inversor {
	private String nombre;
	private List<Inversiones> inv;
	
	public Inversor(String nombre) {
		super();
		this.nombre = nombre;
		this.inv = new ArrayList<>();
	}
	
	public double valorActual() {
		return (this.inv.stream().mapToDouble(Inversiones :: valorActual).sum());
	}

	public String getNombre() {
		return nombre;
	}
	
	public void agregarInversion(Inversiones i) {
		inv.add(i);
	}
	
}
