package ar.edu.unlp.info.oo1.objetos_uno.testsPropios;

import ar.edu.unlp.info.oo1.objetos_uno.ejercicio13.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArchivoTest {
	private Archivo arch;
	
	@BeforeEach
	public void setup() {
		this.arch = new Archivo();
		
	}
	
	@Test
	public void testTamanio() {
		arch.setNombre("listado");
		assertEquals("listado", arch.getNombre());
		assertEquals(7, arch.tamanio());
	}
}
