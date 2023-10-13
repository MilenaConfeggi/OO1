package ar.edu.unlp.info.oo1.objetos_uno.ejercicio15;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateLapse {
	private LocalDate from;
	private LocalDate to;
	
	public LocalDate getFrom() {
		return from;
	}
	public LocalDate getTo() {
		return to;
	}
	
	public DateLapse(LocalDate from, LocalDate to) {
		this.from = from;
		this.to = to;
	}
	
	public int sizeInDays() {
		return (int) ChronoUnit.DAYS.between(this.from, this.to) + 1;
	}
	
	public boolean includesDate(LocalDate date) {
		return (date.isAfter(this.getFrom()) && date.isBefore(this.getTo())) || (this.getFrom().equals(date)) || (this.getTo().equals(date));
	}
	
	//Devuelve true si another coincide con el periodo
	public boolean overlaps (DateLapse another) {
		return !(this.to.isBefore(another.getFrom()) || this.from.isAfter(another.to));
	}
	
	
	//Devuelve true si el periodo es posterior a la fecha actual
	public boolean laterFrom () {
		return this.getFrom().isAfter(LocalDate.now());
	}
	
	public boolean equalsTo(LocalDate date) {
		return this.getTo().equals(date);
	}
	
	public boolean equalsFrom(LocalDate date) {
		return this.getFrom().equals(date);
	}
}
