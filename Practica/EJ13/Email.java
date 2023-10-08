package ar.edu.unlp.info.oo1.objetos_uno.ejercicio13;

import java.util.List;
import java.util.ArrayList;

public class Email {
	private String titulo;
	private String cuerpo;
	private List<Archivo> adjuntos;
	
	public Email(String titulo, String cuerpo) {
		this.titulo = titulo;
		this.cuerpo = cuerpo;
		this.adjuntos = new ArrayList<Archivo>();
	}

	public String getCuerpo() {
		return cuerpo;
	}

	public String getTitulo() {
		return titulo;
	}

	
	public boolean contiene(String texto) {
		return (this.titulo.contains(texto)) || (this.cuerpo.contains(texto));
	}
	
	public int tamanio() {
		return ((this.adjuntos.stream().mapToInt(Archivo:: tamanio)).sum()) + this.titulo.length() + this.cuerpo.length();
	}
	
	public void agregarAdjunto(Archivo archivo) {
		this.adjuntos.add(archivo);
	}

	public List<Archivo> getAdjuntos() {
		return adjuntos;
	}
	
	
}
