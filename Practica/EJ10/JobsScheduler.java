package ar.edu.unlp.info.oo1.objetos_uno.ejercicio10;

import java.util.ArrayList;
import java.util.List;

public class JobScheduler {
    protected List<JobDescription> jobs;
    protected Strategy strategy;

    public JobScheduler () {
        this.jobs = new ArrayList<>();
    }

    public void schedule(JobDescription job) {
        this.jobs.add(job);
    }

    public void unschedule(JobDescription job) {
        if (job != null) {
            this.jobs.remove(job);
        }
    }

    public Strategy getStrategy() {
        return this.strategy; 
    }

    public List<JobDescription> getJobs(){
        return jobs;
    }

    public void setStrategy(Strategy aStrategy) {
        this.strategy = aStrategy;
    }

    //Dependiendo de estrategia se avanza en la lista jobs
    public JobDescription next() {
    	JobDescription description= strategy.next(jobs);
    	this.unschedule(description);
    	return description;
    }

}
