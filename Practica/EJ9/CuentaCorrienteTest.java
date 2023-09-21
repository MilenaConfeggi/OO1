package ar.edu.unlp.info.oo1.objetos_uno.testsPropios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.info.oo1.objetos_uno.ejercicio9.*;

public class CuentaCorrienteTest {
	
	private CuentaCorriente cuentaConDescubierto;
	private CuentaCorriente cuentaSinDescubierto;
	private CuentaCorriente cuentaQueTransfiere;
	private CuentaCorriente cuentaDestino;
	
	@BeforeEach
	public void setup() {
		
		this.cuentaConDescubierto = new CuentaCorriente(1000, 100);
		this.cuentaSinDescubierto = new CuentaCorriente(1000);
		this.cuentaQueTransfiere = new CuentaCorriente(4000);
		this.cuentaDestino = new CuentaCorriente(200);
	}
	
	
	//Testeo una cuenta con descubierto con saldo y sin descubierto sin saldo
	@Test
	public void testExtraer() {
		assertEquals(1000, this.cuentaConDescubierto.getSaldo());
		assertEquals(100, this.cuentaConDescubierto.getDescubierto());
		assertEquals(true, this.cuentaConDescubierto.extraer(1050));
		
		assertEquals(1000, this.cuentaSinDescubierto.getSaldo());
		assertEquals(0, this.cuentaSinDescubierto.getDescubierto());
		assertEquals(false, this.cuentaSinDescubierto.extraer(1050));
	}
	
	//Testeo cuenta que tiene saldo para transferir y cuenta que no
	@Test
	public void testTransferirACuenta() {
		assertEquals(4000, this.cuentaQueTransfiere.getSaldo());
		assertEquals(200, this.cuentaDestino.getSaldo());
		assertEquals(true, this.cuentaQueTransfiere.transferirACuenta(2000, cuentaDestino));
		assertEquals(2200, this.cuentaDestino.getSaldo());
		
		assertEquals(2000, this.cuentaQueTransfiere.getSaldo());
		assertEquals(false, this.cuentaQueTransfiere.transferirACuenta(3000, cuentaDestino));
		assertEquals(2200, this.cuentaDestino.getSaldo());
		assertEquals(2000, this.cuentaQueTransfiere.getSaldo());
	}
	
	
	
	
	
}
