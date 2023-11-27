package ar.edu.unlp.info.oo1.objetos_uno.ejercicio18;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Empleado {
	private String nombre;
	private String apellido;
	private int CUIL;
	private LocalDate fnac;
	private boolean conyugue;
	private boolean hijos;
	private LocalDate fecha_inicio;
	private List<Contrato> contratos;
	
	public Empleado(String nombre, String apellido, int CUIL, LocalDate fnac, boolean conyugue, boolean hijos) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.CUIL = CUIL;
		this.fnac = fnac;
		this.conyugue = conyugue;
		this.hijos = hijos;
		this.fecha_inicio = LocalDate.now();
		this.contratos = new ArrayList<Contrato>();
	}
	
	public Contrato contratoActual() {
		return this.getContratos().stream().filter(con -> con.estoyVencido()==false).findFirst().orElse(null);
	}

	public void crearContratoHoras(LocalDate fechaInicio, LocalDate fechaFin, double valorHora, int horas) {
		if (this.contratoActual() == null) {
			Contrato con = new Conhoras(fechaInicio, this, valorHora, horas, fechaFin);
			this.getContratos().add(con);
		}		
	}
	
	public void crearContratoPlanta(LocalDate fechaInicio, double sueldoM, double montoC, double montoH) {
		if (this.contratoActual() == null) {
			Contrato con = new Deplanta(fechaInicio, this, sueldoM, montoC, montoH);
			this.getContratos().add(con);			
		}
	}
	
	//nose si los tengo q almacenar en algun lado o con que existan esta bien
	public void generarRecibo() {
		if (this.contratoActual() != null) {
			Recibo re = new Recibo(this, this.contratoActual().getAntiguedad(), this.contratoActual().montoContrato());
		}
			
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public int getCUIL() {
		return CUIL;
	}

	public LocalDate getFnac() {
		return fnac;
	}

	public boolean isConyugue() {
		return conyugue;
	}

	public boolean isHijos() {
		return hijos;
	}

	public LocalDate getFecha_inicio() {
		return fecha_inicio;
	}

	public List<Contrato> getContratos() {
		return contratos;
	}
	
	
}
