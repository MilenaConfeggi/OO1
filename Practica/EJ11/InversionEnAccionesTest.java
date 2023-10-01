package ar.edu.unlp.info.oo1.objetos_uno.testsPropios;
import ar.edu.unlp.info.oo1.objetos_uno.ejercicio11.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class InversionEnAccionesTest {
	private InversionEnAcciones inversion;
	
	@BeforeEach
	public void setup() {
		this.inversion = new InversionEnAcciones("mile", 8, 100);
		
	}
	
	@Test
	public void testExtraer() {
		assertEquals(8, this.inversion.getCantidad());
		assertEquals(100, this.inversion.getValorUnitario());
		assertEquals(800, this.inversion.valorActual());
	}
}
