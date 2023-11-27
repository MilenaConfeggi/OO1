package ar.edu.unlp.info.oo1.objetos_uno.ejercicio17;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaTelefonico {
	private List<Numero> numerosDisponibles;
	private List<Persona> clientes;
	
	public SistemaTelefonico() {
		this.numerosDisponibles = new ArrayList<Numero>();
		this.clientes = new ArrayList<Persona>();
	}
	
	public void agregarNumeroDisponible(Numero num) {
		this.numerosDisponibles.add(num);
	}
	
	public Fisica agregarClienteF(String nom, String direccion, int dni) {
		//en caso de que no haya numeros disponibles retorna null
		if(this.numerosDisponibles.size() != 0) {
		    Numero num = this.numerosDisponibles.remove(this.numerosDisponibles.size());
		    Fisica per = new Fisica(num, nom, direccion, dni);
		    this.clientes.add(per);
		    return per; 
		}
		else
			return null;
	}
	
	public Juridica agregarClienteJ(String nom, String direccion, int cuil) {
		if(this.numerosDisponibles.size() != 0) {
		    Numero num = this.numerosDisponibles.remove(this.numerosDisponibles.size());
		    Juridica per = new Juridica(num, nom, direccion, cuil);
		    this.clientes.add(per);
		    return per; 
		}
		else
			return null;
	}
	
	public void registrarLlamadaLocal(LocalDate fecha, int hora, int duracion, Numero num1, Numero num2) {
		this.clientes.stream().filter(cli -> cli.esIgual(num1, num2)).forEach(cli -> cli.registrarLlamadaLocal(fecha, hora, duracion, num1, num2));
		
	}
	
	public void registrarLlamadaInterurbana(LocalDate fecha, int hora, int duracion, Numero num1, Numero num2, int distancia) {
		this.clientes.stream().filter(cli -> cli.esIgual(num1, num2)).forEach(cli -> cli.registrarLlamadaInterurbana(fecha, hora, duracion, num1, num2, distancia));
	}
	
	public void registrarLlamadaInternacional(LocalDate fecha, int hora, int duracion, Numero num1, Numero num2, String pais1, String pais2) {
		this.clientes.stream().filter(cli -> cli.esIgual(num1, num2)).forEach(cli -> cli.registrarLlamadaInternacional(fecha, hora, duracion, num1, num2, pais1, pais2));
	}
	
	public Factura facturarLlamadas(Persona cliente, LocalDate fecha1, LocalDate fecha2) {
		return cliente.facturarLlamadas(fecha1, fecha2);
	}
}
