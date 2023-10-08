package ar.edu.unlp.info.oo1.objetos_uno.testsPropios;

import ar.edu.unlp.info.oo1.objetos_uno.ejercicio13.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testClienteDeCorreo {
	private ClienteDeCorreo cliente;
	private Email mail1;
	private Email mail2;
	private Email mail3;
	private Carpeta car1;
	
	
	@BeforeEach
	public void setup() {
		this.cliente = new ClienteDeCorreo();
		this.mail1 = new Email("Informe", "el informe");
		this.mail2 = new Email("Hola", "chauchis");
		this.mail3 = new Email("aaaa", "eeee");
		this.car1 = new Carpeta("cosas");
	}
	
	@Test
	public void testMover() {
		//testeo recibir()
		this.cliente.recibir(this.mail1);
		this.cliente.recibir(this.mail2);
		assertEquals(2, this.cliente.getInbox().getEmails().size());
		//testeo mover()
		this.cliente.mover(mail1, this.cliente.getInbox(), car1);
		assertEquals(false, this.cliente.getInbox().getEmails().contains(this.mail1));
		assertEquals(true, this.car1.getEmails().contains(this.mail1));
		//testeo mover() si el mail no existe en carpeta origen
		this.cliente.mover(mail3, this.cliente.getInbox(), car1);
		assertEquals(false, this.car1.getEmails().contains(this.mail3));
	}
	
	@Test
	public void testBuscar() {
		//Testeo caso que este en inbox
		this.cliente.recibir(this.mail1);
		assertEquals(mail1, this.cliente.buscar("Informe"));
		//testeo caso que este en carpeta
		this.cliente.agregarCarpeta(car1);
		this.car1.agregarMail(mail2);
		assertEquals(mail2, this.cliente.buscar("Hola"));
		//testeo caso que no este
		assertEquals(null, this.cliente.buscar("noexisto"));
	}
	
	@Test
	public void testEspacioOcupado() {
		this.cliente.recibir(this.mail1);
		this.cliente.agregarCarpeta(car1);
		this.car1.agregarMail(mail2);
		assertEquals(29, this.cliente.espacioOcupado());
	}
}
