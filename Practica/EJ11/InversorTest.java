package ar.edu.unlp.info.oo1.objetos_uno.testsPropios;
import ar.edu.unlp.info.oo1.objetos_uno.ejercicio11.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class InversorTest {
	private Inversor inversor;
	
	@BeforeEach
	public void setup() {
		this.inversor = new Inversor("milenaria");
		PlazoFijo plazo1 = new PlazoFijo(LocalDate.now().minusDays(5), 1000, 2);
		InversionEnAcciones inv1 = new InversionEnAcciones("milanesa", 8, 100);
		InversionEnAcciones inv2 = new InversionEnAcciones("pure", 5, 200);
		InversionEnAcciones inv3 = new InversionEnAcciones("limon", 1, 100);
		this.inversor.agregarInversion(plazo1);
		this.inversor.agregarInversion(inv1);
		this.inversor.agregarInversion(inv2);
		this.inversor.agregarInversion(inv3);
	}
	
	@Test
	public void testvalorActual() {
		assertEquals(3000, this.inversor.valorActual());
	}
}
