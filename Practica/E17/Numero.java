package ar.edu.unlp.info.oo1.objetos_uno.ejercicio17;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Numero {
	private int numero;
	private List<Llamada> llamadas;
	
	public Numero(int numero) {
		super();
		this.numero = numero;
		this.llamadas = new ArrayList<Llamada>();
	}
	
	public void registrarLlamadaLocal(LocalDate fecha, int hora, int duracion, Numero num) {
		Llamada llamada = new Local(fecha, hora, duracion, num);
		this.llamadas.add(llamada);
	}
	
	public void registrarLlamadaInterurbana(LocalDate fecha, int hora, int duracion, Numero num, int distancia) {
		Llamada llamada = new Interurbana(fecha, hora, duracion, num, distancia);
		this.llamadas.add(llamada);
	}
	
	public void registrarLlamadaInternacional(LocalDate fecha, int hora, int duracion, Numero num, String pais1, String pais2) {
		Llamada llamada = new Internacional(fecha, hora, duracion, num, pais1, pais2);
		this.llamadas.add(llamada);
	}
	
	public double facturarLlamadas(LocalDate fecha1, LocalDate fecha2) {
		return this.llamadas.stream().filter(llamada -> llamada.overlaps(fecha1, fecha2)).mapToDouble(Llamada::precioLlamada).sum();
	}

	public int getNumero() {
		return numero;
	}

	public List<Llamada> getLlamadas() {
		return llamadas;
	}
	
	
}
