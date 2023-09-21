package ar.edu.unlp.info.oo1.objetos_uno.ejercicio9;

public class CuentaCorriente extends Cuenta{
	private double descubierto;
	
	//Constructor default
	public CuentaCorriente(double saldo) {
		super(saldo);
		this.descubierto = 0;
	}

	//Constructor con descubierto especifico
	public CuentaCorriente(double saldo, double descubierto) {
		super(saldo);
		this.descubierto = descubierto;
	}

	public double getDescubierto() {
		return descubierto;
	}

	public void setDescubierto(double descubierto) {
		this.descubierto = descubierto;
	}

	//Implemento metodo abstracto donde verifico que el monto sea menos que el saldo + descubierto
	protected boolean puedeExtraer(double monto) {
		return ((this.getSaldo() + this.descubierto) >= monto);		
	}
	
	
}
