package ar.edu.unlp.info.oo1.objetos_uno.ejercicio8;

import java.util.List;
import java.util.ArrayList;

public class Usuario {
	private String domicilio;
	private String nombre;
	private List<Consumo> mediciones;
	private List<Factura> facturas;
	
	public Usuario() {
	}

	public Usuario(String domicilio, String nombre) {
		this.domicilio = domicilio;
		this.nombre = nombre;
		this.mediciones = new ArrayList<Consumo>();
		this.facturas = new ArrayList<Factura>();
	}
	
	public void agregarMedicion(Consumo medicion) {		
		this.mediciones.add(medicion);
	}
	
	public double UltimoConsumoActiva() {
		if (this.UltimoConsumo() != null) 
			return (this.UltimoConsumo().getConsumoEnergiaActiva());
		else
			return 0d;	
	}
	
	public Consumo UltimoConsumo() {
		//Retorna el ultimo consumo o null en el caso de que no exista
		return (this.mediciones.stream().max((Consumo c1, Consumo c2) -> c1.getFecha().compareTo(c2.getFecha()))).orElse(null);
	}
	
	public Factura facturarEnBaseA(double precioKWh) {
		//meto en variable el ultimo consumo
		Consumo ultimo = this.UltimoConsumo();
		//En caso de que sea null creo una factura vacia
		Factura factura;
		double descuento = 0;
		if (ultimo == null) { 
			factura = new Factura(0, descuento, this);
		}
		else {
			//Si existe me fijo que el factor de potencia sea mayor a 0.8
			if (ultimo.factorDePotencia() >= 0.8) {
				descuento = 10;
			}
			//Creo factura que recibe el precio basado en kilowatt/hora
			factura = new Factura(ultimo.costoEnBaseA(precioKWh), descuento, this);
		
		
		}
		//Agrego a lista de facturas del usuario
		this.facturas.add(factura);
		return factura;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public String getNombre() {
		return nombre;
	}

	public List<Consumo> getMediciones() {
		return mediciones;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}
	
	
}
