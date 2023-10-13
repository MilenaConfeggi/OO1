package ar.edu.unlp.info.oo1.objetos_uno.testsPropios.ej15;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.info.oo1.objetos_uno.ejercicio15.*;
public class SistemaDePropiedadesTest {
	private SistemaDePropiedades elsistema;
	private Usuario usuario;
	private Propiedad propiedad1;
	private Propiedad propiedad2;
	private Propiedad propiedad3;
	private Reserva reserva1;
	private Reserva reserva2;
	private Reserva reserva3;
	private Reserva reserva4;
	private Usuario inquilino;
	private Usuario inquilino2;
	private DateLapse periodo1;
	private DateLapse periodo2;
	private DateLapse periodo3;
	
	@BeforeEach
	public void setup() {
		this.elsistema = new SistemaDePropiedades();
		
		this.inquilino = new Usuario("el inquilino", "999", 324);
		this.inquilino2 = new Usuario("inquilino 2.0", "111", 444);
		
		this.periodo1 = new DateLapse(LocalDate.of(2020, 10, 3), LocalDate.of(2020, 10, 15));
		this.periodo2 = new DateLapse(LocalDate.of(2023, 11, 20), LocalDate.of(2023, 11, 30));
		this.periodo3 = new DateLapse(LocalDate.of(2023, 4, 22), LocalDate.of(2023, 4, 30));
		
		this.reserva1 = new Reserva(this.periodo1, this.inquilino);
		this.reserva2 = new Reserva(this.periodo2, this.inquilino);
		this.reserva3 = new Reserva(this.periodo2, this.inquilino);
		this.reserva4 = new Reserva(this.periodo3, this.inquilino2);
		
		this.propiedad1 = new Propiedad("Lacasita", "basta", 100, "lejos");
		this.propiedad2 = new Propiedad("Lacasita2", "basta2", 150, "cerca");
		this.propiedad3 = new Propiedad("Lacasita3", "basta3", 90, "nose");
		
		this.propiedad1.agregarReserva(reserva1);
		this.propiedad1.agregarReserva(reserva2);
		this.propiedad2.agregarReserva(reserva3);
		this.propiedad3.agregarReserva(reserva4);
		
		
		this.elsistema.RegistrarUsuario("el rich", "777", 987);
		this.elsistema.RegistrarUsuario("yo", "1000", 900);
		this.elsistema.getUsuarios().get(0).agregarPropiedad(propiedad1);
		this.elsistema.getUsuarios().get(0).agregarPropiedad(propiedad2);
		this.elsistema.getUsuarios().get(1).agregarPropiedad(propiedad3);
		
	}
	
	@Test
	public void testPropiedadesDisponibles() {
		assertEquals(2, this.elsistema.propiedadesDisponibles(periodo1).size());
		//fechas limite
		DateLapse date = new DateLapse(LocalDate.of(2020, 10, 3), LocalDate.of(2023, 11, 30));
		assertEquals(0, this.elsistema.propiedadesDisponibles(date).size());
	}
	
	@Test
	public void testObtenerReserva() {
		assertEquals(3, this.elsistema.obtenerReservas(inquilino).size());
		assertEquals(0, this.elsistema.obtenerReservas(usuario).size());
	}
	
	@Test
	public void testCalcularPrecioDeReserva() {
		assertEquals(1300, this.elsistema.calcularPrecioDeReserva(reserva1));
		Reserva reservaFea = new Reserva(this.periodo1, this.inquilino);
		assertEquals(-1, this.elsistema.calcularPrecioDeReserva(reservaFea));
	}
	
	@Test
	public void testIngresosPropietario() {
		assertEquals(4050, this.elsistema.ingresosPropietario(this.elsistema.getUsuarios().get(0),LocalDate.of(2020, 10, 3), LocalDate.of(2023, 11, 30)));
	}

}
