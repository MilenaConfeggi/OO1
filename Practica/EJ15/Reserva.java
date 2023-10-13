package ar.edu.unlp.info.oo1.objetos_uno.ejercicio15;

public class Reserva {
	private DateLapse periodo;
	private Usuario usuario;
	
	public Reserva(DateLapse periodo, Usuario usuario) {
		this.periodo = periodo;
		this.usuario = usuario;
	}
	
	public int cantidadDeDias() {
		return this.periodo.sizeInDays();
	}
	
	//Devuelve true si el periodo es posterior a la fecha actual
	public boolean inicioPosterior() {
		return periodo.laterFrom();
	}
	
	//Devuelve true si el periodo pasado como parametro se encuentra en el periodo de la reserva
	public boolean overlaps(DateLapse periodo) {
		return this.periodo.overlaps(periodo);
	}

	//Si el usuario recibido como paretro es el que hixo la reserva devuelve true
	public boolean esDeUsuario(Usuario usuario) {
		return this.usuario.equals(usuario);
	}
	public DateLapse getPeriodo() {
		return periodo;
	}

	
	
	
}
