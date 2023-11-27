package ar.edu.unlp.info.oo1.objetos_uno.ejercicio18;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Empresa {
	private List<Empleado> empleados;
	
	
	public Empresa() {
		this.empleados = new ArrayList<Empleado>();
	}

	public void agregarEmpleado(String nombre, String apellido, int CUIL, LocalDate fnac, boolean conyugue, boolean hijos) {
		Empleado emp = new Empleado(nombre, apellido, CUIL, fnac, conyugue, hijos);
		this.empleados.add(emp);
	}
	
	public Empleado buscarEmpleado(int CUIL) {
		return this.empleados.stream().filter(emp -> emp.getCUIL() == CUIL).findFirst().orElse(null);
	}
	
	public void bajarEmpleado(Empleado emp) {
		this.empleados.remove(emp);
	}
	
	//yo asumo que el empleado esta en la lista??
	public void crearContratoPorHoras(Empleado emp, LocalDate fechaInicio, LocalDate fechaFin, double valorHora, int horas) {
		emp.crearContratoHoras(fechaInicio, fechaFin, valorHora, horas);
	}
	
	public void crearContratoDePlanta(Empleado emp, LocalDate fechaInicio, double sueldoM, double montoC, double montoH) {
		emp.crearContratoPlanta(fechaInicio, sueldoM, montoC, montoH);
	}
	
	//aquellos empleados que no tienen contrato actual es que estan vencidos
	public List<Empleado> empleadosConVencidos(){
		return this.getEmpleados().stream().filter(emp -> emp.contratoActual().equals(null)).collect(Collectors.toList());
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}
	
	
}
