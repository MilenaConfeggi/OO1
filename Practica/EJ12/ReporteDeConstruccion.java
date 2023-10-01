package ar.edu.unlp.info.oo1.objetos_uno.ejercicio12;

import java.util.List;
import java.util.ArrayList;
public class ReporteDeConstruccion {
	private List<Pieza> piezas;
	
	
	
	public ReporteDeConstruccion() {
		this.piezas = new ArrayList<Pieza>();
	}


	public double getVolumenDeMaterial(String nombreMaterial) {
		return this.piezas.stream().filter(pieza -> pieza.getMaterial().equals(nombreMaterial)).mapToDouble(Pieza:: getVolumen).sum();
	}
	
	public double getSuperficieDeColor(String color) {
		return this.piezas.stream().filter(pieza -> pieza.getColor().equals(color)).mapToDouble(Pieza:: getSuperficie).sum();
	}
}
