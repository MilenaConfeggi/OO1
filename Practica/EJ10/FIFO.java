package ar.edu.unlp.info.oo1.objetos_uno.ejercicio10;

import java.util.List;

public class FIFO implements Strategy {
	
	//Retorna primer elemento de la lista
	public JobDescription next(List <JobDescription>jobs) {
        return jobs.get(0);

	}
}
