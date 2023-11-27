package ar.edu.unlp.info.oo1.objetos_uno.ejercicio18;

import java.time.LocalDate;

public class Deplanta extends Contrato{
	private double sueldo_mensual;
	private double monto_conyugue;
	private double monto_hijos;
	
	public Deplanta(LocalDate fechaInicio, Empleado emp, double sueldo_mensual, double monto_conyugue, double monto_hijos) {
		super(fechaInicio, emp);
		this.sueldo_mensual = sueldo_mensual;
		this.monto_conyugue = monto_conyugue;
		this.monto_hijos = monto_hijos;
	}
	
	public boolean estoyVencido() {
		return false;
	}
	
	public double montoContrato() {
	    double mon = this.sueldo_mensual;
	    if (this.getEmp().isConyugue())
	    	mon += this.monto_conyugue;
	    if(this.getEmp().isHijos())
	    	mon += this.monto_hijos;
	    return mon;
	    
	}

	public double getSueldo_mensual() {
		return sueldo_mensual;
	}

	public double getMonto_conyugue() {
		return monto_conyugue;
	}

	public double getMonto_hijos() {
		return monto_hijos;
	}
	
	
}
