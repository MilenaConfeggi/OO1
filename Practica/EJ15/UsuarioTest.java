package ar.edu.unlp.info.oo1.objetos_uno.testsPropios.ej15;
import ar.edu.unlp.info.oo1.objetos_uno.ejercicio15.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class UsuarioTest {
	private Usuario usuario;
	private Propiedad propiedad1;
	private Propiedad propiedad2;
	private Reserva reserva1;
	private Reserva reserva2;
	private Reserva reserva3;
	private Usuario inquilino;
	private DateLapse periodo1;
	private DateLapse periodo2;
	
	@BeforeEach
	public void setup() {
		this.inquilino = new Usuario("el inquilino", "999", 324);
		this.periodo1 = new DateLapse(LocalDate.of(2020, 10, 3), LocalDate.of(2020, 10, 15));
		this.periodo2 = new DateLapse(LocalDate.of(2023, 11, 20), LocalDate.of(2023, 11, 30));
		this.reserva1 = new Reserva(this.periodo1, this.inquilino);
		this.reserva2 = new Reserva(this.periodo2, this.inquilino);
		this.reserva3 = new Reserva(this.periodo2, this.inquilino);
		this.propiedad1 = new Propiedad("Lacasita", "basta", 100, "lejos");
		this.propiedad1.agregarReserva(reserva1);
		this.propiedad1.agregarReserva(reserva2);
		this.propiedad2 = new Propiedad("Lacasita2", "basta2", 150, "cerca");
		this.propiedad2.agregarReserva(reserva3);
		this.usuario = new Usuario("el rich", "777", 987);
		this.usuario.agregarPropiedad(propiedad1);
		this.usuario.agregarPropiedad(propiedad2);

	}
	
	@Test
	public void testPropiedadesDisponibles() {
		//solo la propiedad2 disponible
		DateLapse fechas1 =  new DateLapse(LocalDate.of(2020, 10, 1), LocalDate.of(2020, 10, 3));
		assertEquals(1, this.usuario.propiedadesDisponibles(fechas1).size());
		//Ambas propiedades disponibles
		DateLapse fechas2 =  new DateLapse(LocalDate.of(2020, 10, 1), LocalDate.of(2020, 10, 2));
		assertEquals(2, this.usuario.propiedadesDisponibles(fechas2).size());
		//Ninguna propiedad disponible
		DateLapse fechas3 =  new DateLapse(LocalDate.of(2020, 10, 1), LocalDate.of(2023, 12, 30));
		assertEquals(0, this.usuario.propiedadesDisponibles(fechas3).size());
	}
	
	@Test
	public void testEliminarReserva() {
		assertEquals(2, this.propiedad1.getReservas().size());
		this.usuario.eliminarReserva(reserva1);
		assertEquals(1, this.propiedad1.getReservas().size());
	}
	
	@Test
	public void testObtenerReservas() {
		assertEquals(3, this.usuario.obtenerReservas(this.inquilino).size());
		Usuario usuario = new Usuario("unrandom", "000", 123);
		assertEquals(0, this.usuario.obtenerReservas(usuario).size());
	}
	
	@Test
	public void testBuscarPropiedad() {
		assertEquals(this.propiedad1, this.usuario.buscarPropiedad(reserva1));
		//reserva sin propiedad
		Reserva reserva = new Reserva(this.periodo2, this.inquilino);
		assertEquals(null, this.usuario.buscarPropiedad(reserva));
	}
	
	@Test
	public void testObtenerReservasPropiedades() {
		assertEquals(1, this.usuario.obtenerReservasDePropiedades(LocalDate.of(2020, 10, 1), LocalDate.of(2020, 10, 3)).size());
		assertEquals(2, this.usuario.obtenerReservasDePropiedades(LocalDate.of(2023, 11, 20), LocalDate.of(2023, 11, 30)).size());
	}
}
