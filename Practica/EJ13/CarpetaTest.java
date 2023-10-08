package ar.edu.unlp.info.oo1.objetos_uno.testsPropios;

import ar.edu.unlp.info.oo1.objetos_uno.ejercicio13.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarpetaTest {
	private Carpeta car1;
	private Email mail1;
	private Email mail2;
	
	@BeforeEach
	public void setup() {
		this.mail1 = new Email("Informe", "el informe");
		this.mail2 = new Email("Hola", "chauchis");
		this.car1 = new Carpeta("Importante");
	}
	
	@Test
	public void testAgregarYEliminar() {
		this.car1.agregarMail(mail1);
		assertEquals(1, this.car1.getEmails().size());
		this.car1.eliminarMail(mail1);
		assertEquals(0, this.car1.getEmails().size());
	}

	@Test
	public void testContiene() {
		assertEquals("Importante", this.car1.getNombre());
		this.car1.agregarMail(this.mail1);
		this.car1.agregarMail(this.mail2);
		assertEquals(mail1, this.car1.contiene("Informe"));
		assertEquals(null, this.car1.contiene("slay"));
		
	}
	
	@Test
	public void testEspacioOcupa() {
		this.car1.agregarMail(this.mail1);
		this.car1.agregarMail(this.mail2);
		assertEquals(29, this.car1.espacioOcupa());
	}
}
