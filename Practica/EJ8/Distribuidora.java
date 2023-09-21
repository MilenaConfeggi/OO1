package ar.edu.unlp.info.oo1.objetos_uno.ejercicio8;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
public class Distribuidora {
	private double precioKWh;
	private List<Usuario> usuarios;
	
	public Distribuidora() {
		super();
	}

	public Distribuidora(double precioKWh) {
		this.precioKWh = precioKWh;
		this.usuarios = new ArrayList<Usuario>();
	}
	
	public void agregarUsuario(Usuario user) {
		this.usuarios.add(user);
	}

	public double getPrecioKW() {
		return precioKWh;
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public double consumoTotalActiva() {
		  //Devuelvo el total de la energia activa consumida por todos los usuarios en el ultimo mes
		  return this.usuarios
				      .stream()
				      .mapToDouble((Usuario u) -> u.UltimoConsumoActiva())
				      .sum();
	}
	
	public List<Factura> facturar() {
		//PREGUNTAR!!!!!!
		List<Factura> result = this.usuarios
			.stream()
			.map((Usuario u) -> u.facturarEnBaseA(this.precioKWh))
			.collect(Collectors.toList());
		return result;
	}
	
	
}
 
