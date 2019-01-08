package com.cags.EC;

import java.util.List;

/**
 * Superclass containing the phenotype and its fitness.
 */
public abstract class Individual<P> {
		
	protected double fitness = 0;
	protected Phenotype<P> phenotype;

	public abstract List<P> getPhenotype();
	
	public Individual( Phenotype<P> phenotype) {		
		this.phenotype = phenotype;
	}
	
	public void setFitness(double fitness) {
		this.fitness = fitness;
	}
	
	public double getFitness() {
		return this.fitness;
	}
	
}
