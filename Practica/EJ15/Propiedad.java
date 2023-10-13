package ar.edu.unlp.info.oo1.objetos_uno.ejercicio15;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.time.LocalDate;

public class Propiedad {
	private String nombre;
	private String descripcion;
	private double precioNoche;
	private String direccion;
	private List<Reserva> reservas;
	
	public Propiedad(String nombre, String descripcion, double precioNoche, String direccion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioNoche = precioNoche;
		this.direccion = direccion;
		this.reservas = new ArrayList<Reserva>();
	}
	
	//Retorna false si r tiene elementos y retorna true si es null
	public boolean seEncuentraLibre(DateLapse periodo) {
		Reserva r = this.reservas.stream().filter(elem -> elem.overlaps(periodo)).findFirst().orElse(null);
		if (r != null)
			return false;
		else
			return true;
		
	}
	
	//elimina reserva de lista de reservas
	public void eliminarReserva(Reserva reserva) {
		this.reservas.remove(reserva);
	}
	
	//agrega reserva a lista de reservas
	public void agregarReserva(Reserva reserva) {
		this.reservas.add(reserva);
	}
	
	//Devuelve lista de reservas del usuario mandado como parametro
	public List<Reserva> obtenerReservaUsuario(Usuario usuario){
		return this.reservas.stream().filter(reserva -> reserva.esDeUsuario(usuario)).collect(Collectors.toList());
	}
	
	public List<Reserva> obtenerReservasFechas(LocalDate fecha1, LocalDate fecha2){
		DateLapse periodo = new DateLapse(fecha1, fecha2);
		return this.reservas.stream().filter(reser -> reser.overlaps(periodo)).collect(Collectors.toList());
	}
	
	//Devuelve true si la reserva se encuentra en la lista de reservas de la propiedad
	public boolean contieneReserva(Reserva reserva) {
		return this.reservas.contains(reserva);
	}
	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public double getPrecioNoche() {
		return precioNoche;
	}

	public String getDireccion() {
		return direccion;
	}

	
	public List<Reserva> getReservas() {
		return reservas;
	}
	
	
	
	
	
}
