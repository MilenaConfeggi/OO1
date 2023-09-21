package ar.edu.unlp.info.oo1.objetos_uno.ejercicio10;

import java.util.List;

//Interfaz que usaran todos los tipos de estrategisa
public interface Strategy {
	public JobDescription next(List <JobDescription>jobs);
}
