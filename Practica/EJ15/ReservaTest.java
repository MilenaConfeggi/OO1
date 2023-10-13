package ar.edu.unlp.info.oo1.objetos_uno.testsPropios.ej15;
import ar.edu.unlp.info.oo1.objetos_uno.ejercicio15.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class ReservaTest {
	private Reserva reserva1;
	private Reserva reserva2;
	private Usuario inquilino;
	private DateLapse periodo1;
	private DateLapse periodo2;
	
	@BeforeEach
	public void setup() {
		this.periodo1 = new DateLapse(LocalDate.of(2020, 10, 3), LocalDate.of(2020, 10, 15));
		this.periodo2 = new DateLapse(LocalDate.of(2023, 11, 20), LocalDate.of(2023, 11, 30));
		this.inquilino = new Usuario("unrandom", "999", 324);
		this.reserva1 = new Reserva(this.periodo1, this.inquilino);
		this.reserva2 = new Reserva(this.periodo2, this.inquilino);
	}
	
	@Test
	public void TestcantidadDeDias() {
		assertEquals(13, this.reserva1.cantidadDeDias());
	}
	
	@Test
	public void testInicioPosterior() {
		assertEquals(LocalDate.of(2020, 10, 3), this.periodo1.getFrom());
		assertEquals(false, this.reserva1.inicioPosterior());
		assertEquals(true, this.reserva2.inicioPosterior());
	}
	
	@Test 
	public void testOverlaps() {
		assertEquals(false, reserva1.overlaps(periodo2));
		assertEquals(true, reserva1.overlaps(periodo1));
		//Busco una fecha que tanto su inicio como fin esten dentro del periodo de la reserva 1
		DateLapse periodo3 = new DateLapse(LocalDate.of(2020, 10, 4), LocalDate.of(2020, 10, 14));
		assertEquals(true, this.reserva1.overlaps(periodo3));
	}
	
	@Test
	public void testEsDeUsuario() {
		assertEquals(true, this.reserva1.esDeUsuario(inquilino));
	}
}
