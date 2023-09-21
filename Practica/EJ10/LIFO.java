package ar.edu.unlp.info.oo1.objetos_uno.ejercicio10;

import java.util.List;

public class LIFO implements Strategy{
	
	//Retorna Ultimo elemento de la lista
	public JobDescription next(List <JobDescription>jobs) {
		return jobs.get(jobs.size()-1);
	}
}
