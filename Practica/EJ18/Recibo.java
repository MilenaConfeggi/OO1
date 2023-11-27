package ar.edu.unlp.info.oo1.objetos_uno.ejercicio18;

import java.time.LocalDate;

public class Recibo {
	private Empleado emp;
	private int antiguedad;
	private LocalDate fecha;
	private double montotot;
	
	public Recibo(Empleado emp, int antiguedad, double montotot) {
		this.emp = emp;
		this.antiguedad = antiguedad;
		this.fecha = LocalDate.now();
		this.montotot = montotot;
	}
	

	public Empleado getEmp() {
		return emp;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public LocalDate getFecha() {
		return fecha;
	}


	public double getMontotot() {
		return montotot;
	}
	
	
	
}
