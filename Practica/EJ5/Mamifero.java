package ar.edu.unlp.info.oo1.objetos_uno.ejercicio5;
import java.time.LocalDate;

public class Mamifero {
	private String identificador;
	private String especie;
	private LocalDate fecha;
	private Mamifero padre;
	private Mamifero madre;
	
	public Mamifero () {
		
	}
	
	public Mamifero(String identificador) {
		this.identificador = identificador;
		
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Mamifero getPadre() {
		return padre;
	}

	public void setPadre(Mamifero padre) {
		this.padre = padre;
	}

	public Mamifero getMadre() {
		return madre;
	}

	public void setMadre(Mamifero madre) {
		this.madre = madre;
	}
	
	public Mamifero getAbueloMaterno () {
		//Si no tiene abuelo o si no tiene madre se retorna null
		if (this.getMadre()!= null)
			return (this.getMadre().getPadre());
		else
			return null;
	}
	
	public Mamifero getAbuelaMaterna () {
		//Si no tiene abuela o si no tiene madre se retorna null
		if (this.getMadre()!= null)
			return (this.getMadre().getMadre());
		else
			return null;
	}
	
	public Mamifero getAbueloPaterno () {
		//Si no tiene abuelo o si no tiene padre se retorna null
		if (this.getPadre()!= null)
			return (this.getPadre().getPadre());
		else
			return null;
	}
	
	public Mamifero getAbuelaPaterna () {
		//Si no tiene abuela o si no tiene padre se retorna null
		if (this.getPadre()!= null)
			return (this.getPadre().getMadre());
		else
			return null;
	}
	
	public boolean tieneComoAncestroA (Mamifero unMamifero) {
		boolean ancestro = false;
		if (this.getMadre() != null) {
			if (this.getMadre().equals(unMamifero))
				ancestro = true;
			else
				ancestro = this.getMadre().tieneComoAncestroA(unMamifero);
		}
		if ((!ancestro) && (this.getPadre()!= null)) {
			if (this.getPadre().equals(unMamifero))
				ancestro = true;
			else
				ancestro = this.getPadre().tieneComoAncestroA(unMamifero);
		}
		return ancestro;
	}
	
	
	
}
