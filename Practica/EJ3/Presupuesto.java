package ar.edu.unlp.info.oo1.objetos_uno.ejercicio3;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Presupuesto {
	private LocalDate fecha = LocalDate.now();
	private String cliente;
	private List<Item> items;
	
	
	public Presupuesto (String nombre) {
		this.cliente= nombre;
		this.fecha = LocalDate.now();
		 this.items = new ArrayList<Item>();
	
	}

	public void agregarItem (Item item) {
		this.items.add(item);
	}
	
	public double calcularTotal() {
		if (!this.items.isEmpty()) 
			return items.stream().mapToDouble(Item -> Item.costo()).sum(); //no entendí
		else return 0;		
	}

	public LocalDate getFecha() {
		return fecha;
	}


	public String getCliente() {
		return cliente;
	}
	
	
}
