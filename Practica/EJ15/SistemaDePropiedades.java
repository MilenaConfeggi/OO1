package ar.edu.unlp.info.oo1.objetos_uno.ejercicio15;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.time.LocalDate;
public class SistemaDePropiedades {
	private List<Usuario> usuarios;
	
	
	public SistemaDePropiedades() {
		this.usuarios = new ArrayList<Usuario>();
		
	}


	public void RegistrarUsuario(String nombre, String direccion, int dni) {
		Usuario user = new Usuario(nombre, direccion, dni);
		this.usuarios.add(user);
	}
	
	//Creo una propiedad y busco entre la lista de usuarios el usuario pasado como parametro. Añado la propiedad a la lista de propiedades del usuario
	public void RegistrarPropiedad(String nombre, String descripcion, double precioN, String direccion, Usuario usuario) {
		Propiedad propiedad = new Propiedad(nombre, descripcion, precioN, direccion);
		Usuario u = this.usuarios.stream().filter(user -> user == usuario).findFirst().orElse(null);
		if (u != null)
		  u.agregarPropiedad(propiedad);

	}
	
	//Se verifica que la propiedad este libre en periodo, se crea reserva y se agrega a las reservas de la propiedad
	public Reserva hacerReserva(Propiedad propiedad, DateLapse periodo, Usuario inquilino) {
		if(propiedad.seEncuentraLibre(periodo)) {
			Reserva reserva = new Reserva(periodo, inquilino);
			propiedad.agregarReserva(reserva);
			return reserva;
		}
		else
			return null;
	}
	
	//Busca en lista de usuarios las propiedadesDisponibles(periodo)
	public List<Propiedad> propiedadesDisponibles(DateLapse periodo){
		List<Propiedad> l = new ArrayList<Propiedad>();
		this.usuarios.stream().forEach(user -> l.addAll(user.propiedadesDisponibles(periodo)));
		return l;

	}
	
	//Si reserva inicia despues, se busca en los usuarios quien tiene esa reserva
	public void eliminarReserva(Reserva reserva) {
		if (reserva.inicioPosterior()) {	
			this.usuarios.stream().forEach(usuario -> usuario.eliminarReserva(reserva));
		}
	}
	
	//A cada usuario de la lista se le buscan sus reservas
	public List<Reserva> obtenerReservas(Usuario usuario){
		List<Reserva> l = new ArrayList<Reserva>();
		this.usuarios.stream().forEach(user -> l.addAll(user.obtenerReservas(usuario)));
		return l;
	}
	
	//el map de busacarPropiedad me deberia devolver un stream con todos nulls menos uno, aplico filter para quedarme con ese
	public double calcularPrecioDeReserva(Reserva reserva) {
		Propiedad propiedad = this.usuarios.stream().map(user -> user.buscarPropiedad(reserva)).filter(prop -> prop != null).findFirst().orElse(null);
		if (propiedad != null) {
			return propiedad.getPrecioNoche() * reserva.cantidadDeDias();
		}
		else
			return -1;
	}
	
	//Obtengo todas las reservas de las propiedades del usuario pasado como parametro y aplico la funcion de calcular precio
	public double ingresosPropietario(Usuario usuario, LocalDate fecha1, LocalDate fecha2) {
		return usuario.obtenerReservasDePropiedades(fecha1, fecha2).stream().mapToDouble(reser -> this.calcularPrecioDeReserva(reser)).sum();
	}


	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	
}
