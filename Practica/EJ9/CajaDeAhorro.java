package ar.edu.unlp.info.oo1.objetos_uno.ejercicio9;

public class CajaDeAhorro extends Cuenta{
	
	
	public CajaDeAhorro(double saldo) {
		super(saldo);
	}
	
	//Calcula el monto + 2%
	private double costoTotal(double monto) {
		return (monto + ((monto / 100) * 2));
	}

	//Implemento metodo abstracto que controla que el saldo sea mayor a el monto + 2%
	protected boolean puedeExtraer(double monto) {
		return (((this.getSaldo() - this.costoTotal(monto)) >= 0));
	}
	
	//Deposito el monto - 2%
	public void depositar(double monto) {
		super.depositar(monto - ((monto /100)*2));
	}
	
	//Extraigo el monto + 2%
	public void extraerSinControlar(double monto) {
		super.extraerSinControlar(this.costoTotal(monto));
	}
	
}
