package ar.edu.unlp.info.oo1.objetos_uno.ejercicio6;

import java.util.List;
import java.util.ArrayList;

public class Farola {
	private boolean encendida;
	private List<Farola> vecinas;
	
	public Farola() {	
		this.encendida = false;
		this.vecinas = new ArrayList<Farola>();
	}
	
	public void pairWithNeighbor (Farola otraFarola) {
		this.anadirVecina(otraFarola);
		otraFarola.anadirVecina(this);
	}
	
	private void anadirVecina (Farola otraFarola) {
		this.vecinas.add(otraFarola);
	}

	public List<Farola> getNeighbors() {
		return vecinas;
	}

	public void turnOn() {
		if (!this.encendida) {
			this.encendida = true;
			vecinas.stream().forEach(vecinas -> vecinas.turnOn());
		}
	}
	
	public void turnOff() {
		if (this.encendida) {
			this.encendida=false;
			vecinas.stream().forEach(vecinas -> vecinas.turnOff());
		}
	}
	
	public boolean isOn() {
		return this.encendida;
	}
}
