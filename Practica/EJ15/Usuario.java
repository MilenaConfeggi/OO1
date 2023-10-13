package ar.edu.unlp.info.oo1.objetos_uno.ejercicio15;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;

public class Usuario {
	private String nombre;
	private String direccion;
	private int dni;
	private List<Propiedad> propiedades;
	
	
	public Usuario(String nombre, String direccion, int dni) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.dni = dni;
		this.propiedades = new ArrayList<Propiedad>();

	}
	
	//Añade propiedad a la lista de propiedades del usuario
	public void agregarPropiedad(Propiedad propiedad) {
		this.propiedades.add(propiedad);
	}
	
	//Busca entre las propiedades del usuario aquellas libres en el periodo
	public List<Propiedad> propiedadesDisponibles(DateLapse periodo){
		return this.propiedades.stream().filter(prop -> prop.seEncuentraLibre(periodo)).collect(Collectors.toList());
	}
	
	//Busca en las propiedades de quien es la reserva para eliminarla
	public void eliminarReserva(Reserva reserva) {
		this.propiedades.stream().forEach(prop -> prop.eliminarReserva(reserva));
	}
	
	//Entre todas las listas de reservas de propiedades con valores nulos, devuelva la que tiene contenido
	public List<Reserva> obtenerReservas(Usuario usuario){
		List<Reserva> l = new ArrayList<Reserva>();
		this.propiedades.stream().forEach(prop -> l.addAll(prop.obtenerReservaUsuario(usuario)));
		return l;
	}
	
	//Busca la propiedad a la cual corresponde la reserva
	public Propiedad buscarPropiedad(Reserva reserva) {
		return this.propiedades.stream().filter(prop -> prop.contieneReserva(reserva)).findFirst().orElse(null);
	}

	//Obtiene todas las reservas de sus propiedades en las fechas dadas
	public List<Reserva> obtenerReservasDePropiedades(LocalDate fecha1, LocalDate fecha2){
		List<Reserva> l = new ArrayList<Reserva>();
		this.propiedades.stream().forEach(prop -> l.addAll(prop.obtenerReservasFechas(fecha1, fecha2)));
		return l;
	}
	public String getNombre() {
		return nombre;
	}


	public String getDireccion() {
		return direccion;
	}


	public int getDni() {
		return dni;
	}


	public List<Propiedad> getPropiedades() {
		return propiedades;
	}


	
}
