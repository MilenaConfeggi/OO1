package ar.edu.unlp.info.oo1.objetos_uno.testsPropios;
import static org.junit.jupiter.api.Assertions.assertEquals;
import ar.edu.unlp.info.oo1.objetos_uno.ejercicio11.*;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class PlazoFijoTest {
	private PlazoFijo plazo;
	
	@BeforeEach
	public void setup() {
		this.plazo = new PlazoFijo(LocalDate.now().minusDays(5), 1000, 2);
	}
	
	@Test
	public void testvalorActual() {
		assertEquals(1000, this.plazo.getMontoDepositado());
		assertEquals(2, this.plazo.getPorcentajeDeInteresDiario());
		assertEquals(1100, this.plazo.valorActual());
	}
}
