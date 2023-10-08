package ar.edu.unlp.info.oo1.objetos_uno.ejercicio13;

import java.util.ArrayList;
import java.util.List;

public class ClienteDeCorreo {
	private Carpeta inbox;
	private List<Carpeta> carpetas;
	
	public ClienteDeCorreo() {
		this.inbox = new Carpeta("inbox");
		this.carpetas = new ArrayList<Carpeta>();
	}
	
	public void recibir(Email email) {
		this.inbox.agregarMail(email);
	}
	
	public void mover(Email email, Carpeta origen, Carpeta destino) {
		boolean puedo = origen.eliminarMail(email);
		if (puedo)
			destino.agregarMail(email);
	}
	
	public Email buscar(String texto) {
		for (Carpeta car: carpetas) {
			if (car.contiene(texto) != null) {
				return car.contiene(texto);
			}
		}
		if (this.getInbox().contiene(texto) != null) {
			return this.getInbox().contiene(texto);
		}
		return null;
	}

	public int espacioOcupado() {
		int espacio = 0;
		for (Carpeta car: carpetas) {
			espacio+= car.espacioOcupa();
		}
		espacio+= this.getInbox().espacioOcupa();
		return espacio;
	}

	public Carpeta getInbox() {
		return inbox;
	}

	public List<Carpeta> getCarpetas() {
		return carpetas;
	}
	
	public void agregarCarpeta(Carpeta car) {
		this.carpetas.add(car);
	}
}
