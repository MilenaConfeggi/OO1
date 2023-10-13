package ar.edu.unlp.info.oo1.objetos_uno.testsPropios.ej15;
import ar.edu.unlp.info.oo1.objetos_uno.ejercicio15.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class PropiedadTest {
	private Propiedad propiedad1;
	private Reserva reserva1;
	private Reserva reserva2;
	private Usuario inquilino;
	private DateLapse periodo1;
	private DateLapse periodo2;
	
	@BeforeEach
	public void setup() {
		this.inquilino = new Usuario("el capo", "999", 324);
		this.periodo1 = new DateLapse(LocalDate.of(2020, 10, 3), LocalDate.of(2020, 10, 15));
		this.periodo2 = new DateLapse(LocalDate.of(2023, 11, 20), LocalDate.of(2023, 11, 30));
		this.reserva1 = new Reserva(this.periodo1, this.inquilino);
		this.reserva2 = new Reserva(this.periodo2, this.inquilino);
		this.propiedad1 = new Propiedad("Lacasita", "basta", 100, "lejos");
		
		this.propiedad1.agregarReserva(reserva1);
		this.propiedad1.agregarReserva(reserva2);
	}
	
	@Test
	public void testSeEncuentraLibre() {
		assertEquals(2, this.propiedad1.getReservas().size());
		DateLapse fechas3 = new DateLapse(LocalDate.of(2021, 9, 1), LocalDate.of(2021, 9, 3));
		assertEquals(true, this.propiedad1.seEncuentraLibre(fechas3));
		DateLapse fechas = new DateLapse(LocalDate.of(2020, 10, 4), LocalDate.of(2020, 10, 9));
		assertEquals(false, this.propiedad1.seEncuentraLibre(fechas));
		DateLapse fechas2 = new DateLapse(LocalDate.of(2020, 10, 1), LocalDate.of(2020, 10, 3));
		assertEquals(false, this.propiedad1.seEncuentraLibre(fechas2));
		
	}
	
	@Test
	public void testObtenerReservaUsuario() {
		assertEquals(this.propiedad1.getReservas(), this.propiedad1.obtenerReservaUsuario(inquilino));
		//Testeo a un random que no tiene reservas
		Usuario usuario = new Usuario("unrandom", "000", 123);
		assertEquals(0, this.propiedad1.obtenerReservaUsuario(usuario).size());
	}
	
	@Test
	public void testObtenerReservaFechas() {
		//testeo fechas que si se encuentran
		assertEquals(this.propiedad1.getReservas(), this.propiedad1.obtenerReservasFechas(LocalDate.of(2019, 1, 1), LocalDate.of(2023, 12, 31)));
		//testeo fechas que no se encuentran
		assertEquals(0, this.propiedad1.obtenerReservasFechas(LocalDate.of(2018, 1, 1), LocalDate.of(2018, 12, 31)).size());
		//testeo fecha que solo se encuentra un dia
		assertEquals(1, this.propiedad1.obtenerReservasFechas(LocalDate.of(2020, 9, 30), LocalDate.of(2020, 10, 3)).size());
	}
	
	@Test
	public void testContieneReserva() {
		assertEquals(true, this.propiedad1.contieneReserva(reserva1));
		DateLapse noperiodo = new DateLapse(LocalDate.of(2018, 1, 1), LocalDate.of(2018, 12, 31));
		Reserva noreserva = new Reserva(noperiodo, this.inquilino);
		assertEquals(false, this.propiedad1.contieneReserva(noreserva));
	}
	
}
