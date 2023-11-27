package ar.edu.unlp.info.oo1.objetos_uno.ejercicio19;

public class Domicilio implements Envio{
	private Mapa mapa;
	public double costoEnvio(String direc1, String direc2) {
		this.mapa = new Mapa(direc1, direc2);
		return 0.5 * this.mapa.distanciaEntre();
	}
}
