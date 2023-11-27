package ar.edu.unlp.info.oo1.objetos_uno.ejercicio18;

import java.time.LocalDate;

public class Conhoras extends Contrato{
	private double valor_hora;
	private int horas;
	private LocalDate fechaFin;
	
	public Conhoras(LocalDate fechaInicio, Empleado emp, double valor_hora, int horas, LocalDate fechaFin) {
		super(fechaInicio, emp);
		this.valor_hora = valor_hora;
		this.horas = horas;
		this.fechaFin = fechaFin;
	}
	
	public boolean estoyVencido() {
		if (this.getFechaFin().isBefore(LocalDate.now()))
			return true;		
		else
			return false;
	}
	
	public double montoContrato() {
		return this.valor_hora * this.horas;
	}

	public double getValor_hora() {
		return valor_hora;
	}

	public int getHoras() {
		return horas;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}
	
	
}
