package ar.edu.unlp.info.oo1.objetos_uno.ejercicio18;

import java.time.LocalDate;

public abstract class Contrato {
	private Empleado emp;
	private LocalDate fechaInicio;

	public Contrato(LocalDate fechaInicio, Empleado emp) {
		this.fechaInicio = fechaInicio;
		this.emp = emp;
	}
	
	public abstract boolean estoyVencido();
	
	public abstract double montoContrato();
	
	public int getAntiguedad() {
		return LocalDate.now().getYear() - this.fechaInicio.getYear();
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public Empleado getEmp() {
		return emp;
	}
	
	
}
