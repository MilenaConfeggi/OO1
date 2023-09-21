package ar.edu.unlp.info.oo1.objetos_uno.ejercicio9;

public abstract class Cuenta {
	private double saldo;

	public Cuenta(double saldo) {
		this.saldo = saldo;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public void depositar (double monto) {
		this.saldo+= monto;
	}
	
	protected void extraerSinControlar(double monto) {
		this.saldo-= monto;
	}
	
	//Metodo que extrae de una cuenta
	public boolean extraer(double monto) {
		if (this.puedeExtraer(monto)) {
			this.extraerSinControlar(monto);
			return true;
		}
		return false;
	}
	
	//Metodo que transfiere de una cuenta a otra
	public boolean transferirACuenta(double monto, Cuenta cuentaDestino) {
		if (this.puedeExtraer(monto)) {
			this.extraerSinControlar(monto);
			cuentaDestino.depositar(monto);
			return true;
		}
		return false;
	}
	
	//Metodo abstracto que deben implementar caja y cuenta
	protected abstract boolean puedeExtraer(double monto);
	
}
