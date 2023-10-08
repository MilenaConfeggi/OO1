package ar.edu.unlp.info.oo1.objetos_uno.testsPropios;

import ar.edu.unlp.info.oo1.objetos_uno.ejercicio13.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmailTest {
	private Email mail;
	private Archivo arch1;
	private Archivo arch2;
	
	@BeforeEach
	public void setup() {
		this.mail = new Email("Transferencia", "La transferencia se realizo con exito");
		this.arch1 = new Archivo("informacion");
		this.arch2 = new Archivo("listado");
	}
	
	@Test
	public void TestContiene() {
		assertEquals("Transferencia", this.mail.getTitulo());
		assertEquals("La transferencia se realizo con exito", this.mail.getCuerpo());
		assertEquals(true, this.mail.contiene("realizo"));
		assertEquals(false, this.mail.contiene("hola"));
		assertEquals(true, this.mail.contiene("Transferencia"));
	}
	
	@Test
	public void TestTamanio() {
		this.mail.agregarAdjunto(this.arch1);
		this.mail.agregarAdjunto(this.arch2);
		assertEquals("Transferencia", this.mail.getTitulo());
		assertEquals("La transferencia se realizo con exito", this.mail.getCuerpo());
		assertEquals(68, this.mail.tamanio());
	}
}
