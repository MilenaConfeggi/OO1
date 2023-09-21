package ar.edu.unlp.info.oo1.objetos_uno.testsPropios;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.info.oo1.objetos_uno.ejercicio9.*;

public class CajaAhorroTest {
	private CajaDeAhorro cajaExtraer;
	private CajaDeAhorro cajaTransfiere;
	private CajaDeAhorro cajaDestino;
	private CuentaCorriente cuentaDestino;
	
	@BeforeEach
	public void setup() {
		this.cajaExtraer = new CajaDeAhorro(1000);
		this.cajaTransfiere = new CajaDeAhorro(2000);
		this.cajaDestino = new CajaDeAhorro(200);
		this.cuentaDestino = new CuentaCorriente(300);
	}
	
	//Testeo situacion en la que se extrae a caja de ahorro con saldo y sin saldo suficiente
	@Test
	public void testExtraer() {
		assertEquals(1000, this.cajaExtraer.getSaldo());
		assertEquals(true, this.cajaExtraer.extraer(100));
		assertEquals(898, this.cajaExtraer.getSaldo());
		assertEquals(false, this.cajaExtraer.extraer(1000));
		assertEquals(898, this.cajaExtraer.getSaldo());
		
		assertEquals(false, this.cajaExtraer.extraer(1000));
		assertEquals(898, this.cajaExtraer.getSaldo());
	}
	
	//Testeo situacion en la que caja de ahorro le transfiere a caja de ahorro con y sin saldo suficiente
	@Test
	public void testTransferirACuentaCajaDeAhorro() {
		assertEquals(2000, this.cajaTransfiere.getSaldo());
		assertEquals(200, this.cajaDestino.getSaldo());
		assertEquals(true, this.cajaTransfiere.transferirACuenta(100, cajaDestino));
		assertEquals(1898, this.cajaTransfiere.getSaldo());
		assertEquals(298, this.cajaDestino.getSaldo());
		
		assertEquals(false, this.cajaTransfiere.transferirACuenta(2000, cuentaDestino));
		assertEquals(1898, this.cajaTransfiere.getSaldo());
		assertEquals(298, this.cajaDestino.getSaldo());
		
	}
	
	//Testeo situacion en la que caja de ahorro le transfiere a cuenta corriente
	@Test
	public void testTransferirACuentaCuentaCorriente() {
		assertEquals(2000, this.cajaTransfiere.getSaldo());
		assertEquals(300, this.cuentaDestino.getSaldo());
		assertEquals(true, this.cajaTransfiere.transferirACuenta(100, cuentaDestino));
		assertEquals(1898, this.cajaTransfiere.getSaldo());
		assertEquals(400, this.cuentaDestino.getSaldo());
		
	}
}
