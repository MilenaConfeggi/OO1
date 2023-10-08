package ar.edu.unlp.info.oo1.objetos_uno.ejercicio13;

import java.util.ArrayList;
import java.util.List;

public class Carpeta {
	private String nombre;
	private List<Email> emails;
	
	

	public Carpeta(String nom) {
		this.nombre = nom;
		this.emails = new ArrayList<Email>();
	}


	public String getNombre() {
		return nombre;
	}
	
	public void agregarMail(Email email) {
		this.emails.add(email);
	}
	
	public boolean eliminarMail(Email email) {
		return this.emails.remove(email);
	}
	
	public Email contiene(String texto) {
		boolean encontre=false;
		int i=0;
		while ((!encontre)&& (i<this.emails.size())) {
			if (this.emails.get(i).contiene(texto)) {
				return this.emails.get(i);
			}
			i++;
		}
		return null;
	}
	
	public int espacioOcupa() {
		return this.emails.stream().mapToInt(Email:: tamanio).sum();
	}

	public List<Email> getEmails() {
		return emails;
	}
	
}
